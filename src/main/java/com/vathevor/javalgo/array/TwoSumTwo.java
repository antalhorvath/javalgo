package com.vathevor.javalgo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;

/*
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers
 * such that they add up to the target,
 * where index1 must be less than index2.
 *
 * Note:
 *      Your returned answers (both index1 and index2) are not zero-based.
 *      You may assume that each input would have exactly one solution
 *      and you may not use the same element twice.
 *
 * Example:
 *      Input: numbers = [2,7,11,15], target = 9
 *      Output: [1,2]
 *      Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumTwo {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, List<Integer>> numberWithIndexMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (numberWithIndexMap.containsKey(number)) {
                numberWithIndexMap.get(number).add(i + 1);
            } else {
                List<Integer> updatedIndexes = new ArrayList<>(singletonList(i + 1));
                numberWithIndexMap.put(number, updatedIndexes);
            }
        }

        for (Integer number : numberWithIndexMap.keySet()) {
            int remainder = target - number;
            if (numberWithIndexMap.containsKey(remainder)) {
                List<Integer> numberPositions = numberWithIndexMap.get(number);
                List<Integer> remainderPositions = numberWithIndexMap.get(remainder);
                int[] result;
                if (numberPositions.equals(remainderPositions) && numberPositions.size() > 1) {
                    result = new int[]{numberPositions.get(0), numberPositions.get(1)};
                } else {
                    result = new int[]{numberPositions.get(0), remainderPositions.get(0)};
                }
                Arrays.sort(result);
                return result;
            }
        }
        return new int[0];
    }
}
