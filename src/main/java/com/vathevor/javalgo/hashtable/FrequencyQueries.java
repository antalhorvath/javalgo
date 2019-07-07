package com.vathevor.javalgo.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * You are given q queries. Each query is of the form two integers described below:
 *      - 1 x: Insert x in your data structure
 *      - 2 y: Delete one occurrence of 'y' from your data structure, if present.
 *      - 3 z: Check if any integer is present whose frequency is exactly 'z'. If yes, print 1 else 0.
 *
 * Example
 * Operation   Array   Output
 * (1,1)       [1]
 * (2,2)       [1]
 * (3,2)                   0
 * (1,1)       [1,1]
 * (1,1)       [1,1,1]
 * (2,1)       [1,1]
 * (3,2)                   1
 *
 * Return an array with the output: [0, 1]
 *
 * Sample Input 0
 *      8
 *      1 5
 *      1 6
 *      3 2
 *      1 10
 *      1 10
 *      1 6
 *      2 5
 *      3 2
 *
 * Sample Output 0
 *      0
 *      1
 *
 * Explanation 0
 *      For the first query of type 3,
 *      there is no integer whose frequency is 2 (array=[5,6]).
 *      So answer is 0.
 *
 *      For the second query of type 3,
 *      there are two integers in array=[6,10,10,6,5] whose frequency is 2 (integers = 6 and 10).
 *      So, the answer is 1.
 */
public class FrequencyQueries {

    /**
     * @param queries
     * @return returns a list of integers where each element is:
     * 1 if there is at least one element value with the queried number of occurrences in the current array
     * 0 if there is not.
     */
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (List<Integer> query : queries) {
            Integer operation = query.get(0);
            Integer value = query.get(1);

            switch (operation) {
                case 1:
                    insert(frequencies, value);
                    break;
                case 2:
                    delete(frequencies, value);
                    break;
                case 3:
                    result.add(containsNumberWithFrequency(frequencies, value));
                    break;
            }
        }
        return result;
    }

    private static void insert(Map<Integer, Integer> frequencies, Integer value) {
        frequencies.computeIfPresent(value, (key, oldValue) -> ++oldValue);
        frequencies.putIfAbsent(value, 1);
    }

    private static void delete(Map<Integer, Integer> frequencies, Integer value) {
        frequencies.computeIfPresent(value, (key, oldValue) -> 0 < oldValue - 1 ? --oldValue : null);
    }

    private static Integer containsNumberWithFrequency(Map<Integer, Integer> frequencies, Integer frequency) {
        return frequencies.values().contains(frequency) ? 1 : 0;
    }
}
