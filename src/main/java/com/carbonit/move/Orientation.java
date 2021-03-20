package com.carbonit.move;

public enum Orientation {
    SOUTH("S"),
    WEST("O"),
    NORTH("N"),
    EAST("E");

    private final String symbol;


    Orientation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
