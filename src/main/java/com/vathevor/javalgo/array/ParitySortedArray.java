package com.vathevor.javalgo.array;

/**
 * #easy
 * Given an array A of non-negative integers.
 * Return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 */
public class ParitySortedArray {

    static int[] getArraySortedByParity(int[] input) {
        int head = 0;
        int tail = input.length - 1;
        int[] output = new int[input.length];
        for (int element : input) {
            if (element % 2 == 0) {
                output[head++] = element;
            } else {
                output[tail--] = element;
            }
        }
        return output;
    }
}
