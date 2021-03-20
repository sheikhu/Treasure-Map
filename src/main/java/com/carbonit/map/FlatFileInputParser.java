package com.carbonit.map;

import com.carbonit.element.*;
import com.carbonit.event.DefaultTileListener;
import com.carbonit.models.*;
import com.carbonit.parsers.*;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FlatFileInputParser implements InputParser {

    private Path path;

    public FlatFileInputParser(Path path) {
        this.path = path;
    }

    @Override
    public Map parse() throws Exception {

        LineParser<Map> mapParser = new MapParser();
        LineParser<Mountain> mountainParser = new MountainParser();
        LineParser<Treasure> treasureParser = new TreasureParser();
        LineParser<Adventurer> adventurerParser = new AdventurerParser();


        List<Adventurer> adventurers = new ArrayList<>();
        List<Tile> tiles = new ArrayList<>();

        try(BufferedReader fileReader = Files.newBufferedReader(this.path)) {

            String line;
            Map map = null;
            while ( (line = fileReader.readLine()) != null) {

                if(line.startsWith("#"))
                    continue;
                String[] splits = line.trim().split("-");
                String caseType = splits[0];

                switch (caseType) {
                    case "C":
                        map = mapParser.parse(line);
                        
                        break;
                    case "M":
                        tiles.add(mountainParser.parse(line));
                        break;
                    case "T":
                        Treasure t = treasureParser.parse(line);
                        t.setTileListener(new DefaultTileListener());
                        tiles.add(t);
                        break;

                    case "A":
                        adventurers.add(
                                adventurerParser.parse(line)
                        );

                        break;
                    default:
                        Plain p = new Plain(
                                new Position(Integer.parseInt(splits[1]),
                                Integer.parseInt(splits[2])));
                        p.setTileListener(new DefaultTileListener());
                        tiles.add(p);
                        break;
                }
            }


            for(Tile t: tiles) {
                assert map != null;
                map.setTile(t);
            }
            assert map != null;
            map.getAdventurers().addAll(adventurers);


            return map;
        }

    }
}
