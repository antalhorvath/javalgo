package com.vathevor.javalgo.array;

/*
 * A string is said to be a special string if either of two conditions is met:
 *     All of the characters are the same, e.g. aaa.
 *     All characters except the middle one are the same, e.g. aadaa.
 *
 * A special substring is any substring of a string which meets one of those criteria. Given a string,
 * determine how many special substrings can be formed from it.
 *
 * For example, given the string s = mnonopoo, we have the following special substrings:
 * {m, n, o, n, o, p, o, o, non, ono, opo, oo}
 *
 */
public class SpecialPalindrome {

    /**
     *
     * @param n length of s
     * @param s string
     * @return an integer representing the number of special substrings that can be formed from the given string
     */

    static long substrCount(int n, String s) {
        char[] sequence = s.toCharArray();

        long count = 0;
        nextStartingPosition:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isSpecial(sequence, i, j)) {
                    count++;
                    continue;
                }
                if (isSubstringWithOddLength(i, j)) {
                    if (isOddlySpecial(sequence, i, j)) {
                        count++;
                        continue nextStartingPosition;
                    }
                }
                if (isDeadEnd(sequence, i, j)) continue nextStartingPosition;
            }
        }

        return count;
    }

    private static boolean isSubstringWithOddLength(int i, int j) {
        return (j - i) % 2 == 1;
    }

    private static boolean isSpecial(char[] sequence, int i, int j) {
        char r = sequence[i];
        // find any mismatch
        for (int k = i + 1; k < j; k++)
            if (sequence[k] != r) return false;

        return true;
    }

    private static boolean isOddlySpecial(char[] sequence, int i, int j) {
        char r = sequence[i];
        int middle = i + ((j - i) / 2);
        // find mismatch in the first part before middle
        for (int k = i + 1; k < middle; k++)
            if (sequence[k] != r) return false;
        // find mismatch in the last part after middle
        for (int k = middle + 1; k < j; k++)
            if (sequence[k] != r) return false;

        return true;
    }

    private static boolean isDeadEnd(char[] sequence, int i, int j) {
        char r = sequence[i];
        int differences = 0;
        // find mismatch to be sure that sequence will not be special if extended
        for (int k = i + 1; k < j; k++)
            if (sequence[k] != r && 1 < ++differences) return true;

        return false;
    }
}
