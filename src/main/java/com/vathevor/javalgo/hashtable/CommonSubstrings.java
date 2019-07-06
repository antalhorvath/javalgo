package com.vathevor.javalgo.hashtable;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

/*
 * Given two strings, determine if they share a common substring.
 * A substring may be as small as one character.
 *
 * For example, the words "a", "and", "art" share the common substring
 *      The words "be" and "cat" do not share a substring.
 *
 * Function Description
 *      Complete the function twoStrings in the editor below.
 *      It should return a string, either YES or NO based on whether the strings share a common substring.
 */
public class CommonSubstrings {

    static String twoStrings(String s1, String s2) {
        Set<String> lettersOfS1 = new HashSet<>(asList(s1.split("")));
        for(String letter: lettersOfS1) {
            if(s2.contains(letter)) {
                return "YES";
            }
        }
        return "NO";
    }
}
