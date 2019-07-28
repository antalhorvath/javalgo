package com.vathevor.javalgo.general;

public class RomanNumber {

    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private String value;

    private RomanNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RomanNumber valueOf(Integer integer) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            while (integer >= VALUES[i]) {
                integer -= VALUES[i];
                result.append(SYMBOLS[i]);
            }
        }
        return new RomanNumber(result.toString());
    }
}
