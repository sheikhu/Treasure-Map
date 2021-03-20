package com.carbonit.parsers;

import com.carbonit.element.Treasure;
import com.carbonit.models.Position;

public class TreasureParser implements LineParser<Treasure> {
    @Override
    public Treasure parse(String line) throws Exception {
        String[] splits = line.split("-");

        if(!line.startsWith("T") || splits.length != 4)
            throw new Exception(String.format("Invalid line <%s>", line));


        return new Treasure(
                new Position(Integer.parseInt(splits[1].trim()),
                Integer.parseInt(splits[2].trim())),
                Integer.parseInt(splits[3].trim())
                );

    }

    @Override
    public String toLine(Treasure element) {
        return String.format("T-%d-%d-%d",
                element.getPosition().getX(),
                element.getPosition().getY(),
                element.getTreasureCount()
        );
    }
}
