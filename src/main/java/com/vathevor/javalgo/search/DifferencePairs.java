package com.vathevor.javalgo.search;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/* You will be given an array of integers and a target value.
 * Determine the number of pairs of array elements that have a difference equal to a target value.
 * For example, given an array of [1, 2, 3, 4] and a target value of 1,
 * we have three values meeting the condition: 2-1=1, 3-2=1 and 4-3=1
 */
public class DifferencePairs {

    static int pairs(int k, int[] arr) {
        Map<Integer, Long> counts = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int result = 0;
        for (int integer : arr) {
            int subtrahend = integer - k;
            Long countOfPossibleSubtrahends = counts.getOrDefault(subtrahend, 0L);
            result += countOfPossibleSubtrahends;
        }

        return result;
    }
}
