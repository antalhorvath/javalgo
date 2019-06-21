package com.vathevor.javalgo.general;

import java.util.Arrays;

/**
 * #easy
 * Given an array of integers sorted in non-decreasing order.
 * Return an array of the squares of each number, also in sorted non-decreasing order.
 */
public class SquaresOfSortedArray {

    static int[] sortedSquares(int[] elements) {
        int[] result = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            result[i] = elements[i] * elements[i];
        }

        Arrays.sort(result);
        return result;
    }
}
