package com.vathevor.javalgo.sort;

import java.util.Arrays;

/*
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *      Input: s = "anagram", t = "nagaram"
 *      Output: true
 *
 * Example 2:
 *      Input: s = "rat", t = "car"
 *      Output: false
 *
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] lettersOfS = s.toCharArray();
        char[] lettersOfT = t.toCharArray();
        Arrays.sort(lettersOfS);
        Arrays.sort(lettersOfT);
        return Arrays.equals(lettersOfS, lettersOfT);
    }
}
