package com.carbonit.parsers;

import com.carbonit.element.Mountain;
import com.carbonit.models.Position;

public class MountainParser implements LineParser<Mountain> {
    @Override
    public Mountain parse(String line) throws Exception {
        String[] splits = line.split("-");

        if(!line.startsWith("M") || splits.length != 3)
            throw new Exception(String.format("Invalid line <%s>", line));


        return new Mountain(
                new Position(Integer.parseInt(splits[1].trim()),
                Integer.parseInt(splits[2].trim())
                )
        );

    }

    @Override
    public String toLine(Mountain element) {
        return String.format("M-%d-%d",
                element.getPosition().getX(),
                element.getPosition().getY()
        );
    }
}
