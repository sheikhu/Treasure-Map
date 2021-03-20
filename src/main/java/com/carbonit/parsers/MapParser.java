package com.carbonit.parsers;

import com.carbonit.map.Map;
import com.carbonit.map.TreasureMap;

public class MapParser implements LineParser<Map> {
    @Override
    public Map parse(String line) throws Exception {
        String[] splits = line.split("-");

        if(!line.startsWith("C") || splits.length != 3)
            throw new Exception(String.format("Invalid line <%s>", line));


        return new TreasureMap(
                Integer.parseInt(splits[1].trim()),
                Integer.parseInt(splits[2].trim())
        );

    }

    @Override
    public String toLine(Map element) {
        return String.format("C-%d-%d",
                element.getWidth(),
                element.getHeight()
        );
    }
}
