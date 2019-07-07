package com.vathevor.javalgo.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

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

    private static Long getMaxFrequency(List<int[]> queries) {
        return queries.parallelStream()
                .filter(query -> query[0] == 1)
                .count();
    }

    /**
     * @param queries
     * @return returns a list of integers where each element is:
     * 1 if there is at least one element value with the queried number of occurrences in the current array
     * 0 if there is not.
     */
    static List<Integer> freqQuery(List<int[]> queries) {

        long maxFrequency = getMaxFrequency(queries);
        FrequencyCounter frequencyCounter = new FrequencyCounter();
        List<Integer> result = new ArrayList<>();

        Consumer<Integer> frequencyChecker = frequency -> {
            if (maxFrequency < frequency || queries.size() < frequency) {
                result.add(0);
            } else {
                result.add(frequencyCounter.containsNumberWithFrequency(frequency));
            }
        };

        Map<Integer, Consumer<Integer>> operations = new HashMap<>();
        operations.put(1, frequencyCounter::insert);
        operations.put(2, frequencyCounter::delete);
        operations.put(3, frequencyChecker);

        for (int[] query : queries) {
            int operation = query[0];
            int value = query[1];
            operations.get(operation).accept(value);
        }
        return result;
    }

    private static class FrequencyCounter {

        private final Map<Integer, Integer> frequencies = new HashMap<>();

        private void insert(Integer value) {
            frequencies.computeIfPresent(value, (key, oldValue) -> ++oldValue);
            frequencies.putIfAbsent(value, 1);
        }

        private void delete(Integer value) {
            frequencies.computeIfPresent(value, (key, oldValue) -> 0 < oldValue - 1 ? --oldValue : null);
        }

        private Integer containsNumberWithFrequency(Integer frequency) {
            return frequencies.values().contains(frequency) ? 1 : 0;
        }
    }
}
