package com.vathevor.javalgo.hashtable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/*
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 * It is also valid if he can remove just 1 character from the string,
 * and the remaining characters will occur the same number of times.
 *
 * Sample Input 0
 *      aabbcd
 * Sample Output 0
 *      NO
 * Explanation 0
 *      We would need to remove two characters, both c and d to make it valid.
 *      We are limited to removing only one character, so the input is invalid.
 *
 * Sample Input 1
 *      aabbccddeefghi
 * Sample Output 1
 *      NO
 * Explanation 1
 *      Frequency counts for the letters are as follows:
 *      {'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}
 *
 * Sample Input 2
 *      abcdefghhgfedecba
 * Sample Output 2
 *      YES
 * Explanation 2
 *      All characters occur twice except for e which occurs 3 times.
 *      We can delete one instance of to have a valid string.
 */
public class SherlockValidString {

    static boolean isValid(String s) {
        Map<String, Long> countsByLetter = Arrays.stream(s.split(""))
                .collect(groupingBy(identity(), counting()));

        Map<Long, Long> countsByFrequency = countsByLetter.values().stream()
                .collect(groupingBy(identity(), counting()));

        // all letters occur with same frequency
        if (1 == countsByFrequency.keySet().size()) {
            return true;
        }

        // there are more than two kind of frequencies
        if (2 < countsByFrequency.keySet().size()) {
            return false;
        }

        Iterator<Long> frequencyIterator = countsByFrequency.keySet().iterator();

        Long frequency1 = frequencyIterator.next();
        Long frequencyCount1 = countsByFrequency.get(frequency1);
        // if there is a single frequency with one count that could be removed
        if (frequency1 == 1 && frequencyCount1 == 1) {
            return true;
        }

        Long frequency2 = frequencyIterator.next();
        Long frequencyCount2 = countsByFrequency.get(frequency2);
        // if there is a single frequency with one count that could be removed
        if (frequency2 == 1 && frequencyCount2 == 1) {
            return true;
        }

        // if difference between frequencies is more than 1 then it cannot be resolved
        if (1 < Math.abs(frequency1 - frequency2)) {
            return false;
        }

        // one of them could be removed
        return frequencyCount1 == 1 || frequencyCount2 == 1;
    }
}
