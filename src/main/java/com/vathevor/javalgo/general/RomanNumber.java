package com.vathevor.javalgo.general;

public class RomanNumber {

    private String value;

    private RomanNumber() {
    }

    public String getValue() {
        return value;
    }

    public static RomanNumber valueOf(Integer integer) {
        return new RomanNumber();
    }
}
