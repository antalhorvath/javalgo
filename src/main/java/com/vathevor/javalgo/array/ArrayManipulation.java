package com.vathevor.javalgo.array;

import java.util.Arrays;

/*
 * Starting with a 1-indexed array of zeros and a list of operations,
 * for each operation add a value to each of the array element between two given indices, inclusive.
 * Once all operations have been performed, return the maximum value in your array.
 *
 * For example. n = 1
 * a b k
 * 1 5 3
 * 4 8 7
 * 6 9 1
 *
 *  1 2 3  4  5 6 7 8 9 10 // indexes
 * [0,0,0, 0, 0,0,0,0,0, 0]
 * [3,3,3, 3, 3,0,0,0,0, 0]
 * [3,3,3,10,10,7,7,7,0, 0]
 * [3,3,3,10,10,8,8,8,1, 0]
 */
public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {
        long[] steps = new long[n];
        for (int[] query : queries) {
            int startFrom = query[0] - 1;
            int until = query[1];
            int value = query[2];
            // mark the start of the higher value
            steps[startFrom] += value;
            if (until < n) {
                // mark the end of the higher value
                steps[until] -= value;
            }
        }

        long max = 0;
        long tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += steps[i];
            if (max < tmp) {
                max = tmp;
            }
        }
        return max;
    }
}
