package com.vathevor.javalgo.general;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this.
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Example:
 *      Input: s = "PAYPALISHIRING", numRows = 4
 *      Output: "PINALSIGYAHRPI"
 *      Explanation:
 *      P     I    N
 *      A   L S  I G
 *      Y A   H R
 *      P     I
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = Stream.generate(StringBuilder::new)
                .limit(Math.min(numRows, s.length()))
                .collect(toList());

        int row = 0;
        boolean goesDown = true;
        for (int i = 0; i < s.length(); i++) {
            rows.get(row).append(s.charAt(i));
            if (row == 0) {
                goesDown = true;
            } else if (row == numRows - 1) {
                goesDown = false;
            }
            row += goesDown ? 1 : -1;
        }

        return rows.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.joining());
    }
}
