package com.vathevor.javalgo.general;

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
        if(s.length() < 2) {
            return s;
        }

        int[] indices = new int[s.length()];
        int p = 0;

        int l = numRows + numRows - 2;
        int k = s.length() / l + 1;
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < k; i++) {
                int v = i * l + j;
                if (v < s.length()) {
                    indices[p++] = v;
                    int remainder = v % l;
                    if (remainder != 0) {
                        int w = (v / l + 1) * l - remainder;
                        if (w < s.length() && v != w) {
                            indices[p++] = w;
                        }
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            result.append(s.charAt(indices[i]));
        }

        return result.toString();
    }
}
