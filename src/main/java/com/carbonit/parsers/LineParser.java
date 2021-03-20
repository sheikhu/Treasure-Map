package com.carbonit.parsers;

public interface LineParser<T> {

    T parse(String line) throws Exception;

    String toLine(T element);
}
