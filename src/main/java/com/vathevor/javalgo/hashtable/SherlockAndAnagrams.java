package com.vathevor.javalgo.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Two strings are anagrams of each other
 * if the letters of one string can be rearranged to form the other string.
 *
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 *
 * For example s = 'mom', the list of all anagrammatic pairs is [m, m], [mo, om]
 * at positions[[0], [2]], [[0,1], [1,2]] respectively.
 *
 * Function Description
 *
 * Complete the function sherlockAndAnagrams in the editor below.
 * It must return an integer that represents the number of anagrammatic pairs of substrings in.
 */
public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i <= s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char[] lettersOfSubstring = s.substring(i, j).toCharArray();
                Arrays.sort(lettersOfSubstring);
                substrings.add(new String(lettersOfSubstring));
            }
        }

        int counter = 0;
        for (int i = 0; i < substrings.size() - 1; i++) {
            String substring = substrings.get(i);
            for (int j = i + 1; j < substrings.size(); j++) {
                String test = substrings.get(j);
                if(substring.equals(test)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
