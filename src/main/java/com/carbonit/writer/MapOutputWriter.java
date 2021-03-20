package com.carbonit.writer;

import com.carbonit.map.Map;
import com.carbonit.element.Mountain;
import com.carbonit.element.Treasure;
import com.carbonit.models.Position;
import com.carbonit.element.Tile;
import com.carbonit.parsers.AdventurerParser;
import com.carbonit.parsers.MapParser;
import com.carbonit.parsers.MountainParser;
import com.carbonit.parsers.TreasureParser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;

public class MapOutputWriter implements OutputWriter {

    private final Map map;
    private final String output;

    public MapOutputWriter(Map map, String output) {
        this.map = map;
        this.output = output;
    }

    @Override
    public void write() throws IOException {

        MountainParser mountainParser = new MountainParser();
        TreasureParser treasureParser = new TreasureParser();
        AdventurerParser adventurerParser = new AdventurerParser();

        StringJoiner mapString = new StringJoiner(System.lineSeparator());
        StringJoiner mountainsString = new StringJoiner(System.lineSeparator());
        StringJoiner treasureString = new StringJoiner(System.lineSeparator());
        StringJoiner adventurersString = new StringJoiner(System.lineSeparator());

        mapString.add(new MapParser().toLine(map));

        for (int i = 0; i < map.getWidth(); i++) {

            for (int j = 0; j < map.getHeight(); j++) {
                Tile tile = map.getTileAt(new Position(i, j));

                if (tile instanceof Mountain) {
                    mountainsString.add(mountainParser.toLine((Mountain) tile));
                } else if (tile instanceof Treasure) {
                    if (((Treasure) tile).getTreasureCount() > 0) {
                        treasureString.add(treasureParser.toLine((Treasure) tile));
                    }
                }
            }
        }

        map.getAdventurers()
                .forEach(a -> adventurersString.add(adventurerParser.toLine(a)));

        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(this.output));

        bufferedWriter.write(mapString.toString());
        bufferedWriter.newLine();
        bufferedWriter.write(mountainsString.toString());
        bufferedWriter.newLine();
        bufferedWriter.write(treasureString.toString());
        bufferedWriter.newLine();
        bufferedWriter.write(adventurersString.toString());

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
