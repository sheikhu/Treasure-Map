package com.carbonit.parsers;

import com.carbonit.element.Adventurer;
import com.carbonit.move.Compass;
import com.carbonit.models.Position;
import com.carbonit.element.SimpleAdventurer;

import java.util.Arrays;

public class AdventurerParser implements LineParser<Adventurer> {
    @Override
    public Adventurer parse(String line) throws Exception {
        String[] splits = line.split("-");

        if(!line.startsWith("A") || splits.length != 6)
            throw new Exception(String.format("Invalid line <%s>", line));


        return new SimpleAdventurer(
                splits[1].trim(),
                new Position(Integer.parseInt(splits[2].trim()),
                Integer.parseInt(splits[3].trim())),
                Compass.getOrientation(splits[4].trim()),
                Arrays.asList(splits[5].trim().split(""))
        );

    }

    @Override
    public String toLine(Adventurer element) {
        return String.format("A-%s-%d-%d-%s-%d",
                element.getName(),
                element.getPosition().getX(),
                element.getPosition().getY(),
                element.getCompass().getCurrentOrientation().getSymbol(),
                element.getTreasureCount()
                );
    }
}
