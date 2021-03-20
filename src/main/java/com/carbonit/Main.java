package com.carbonit;

import com.carbonit.map.FlatFileInputParser;
import com.carbonit.map.Map;
import com.carbonit.writer.MapOutputWriter;

import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {
        Map map = new FlatFileInputParser(Paths.get(args[0])).parse();

        TreasureHuntSession session = new TreasureHuntSession(map);
        session.run();

        new MapOutputWriter(map, args[1]).write();
    }

}
