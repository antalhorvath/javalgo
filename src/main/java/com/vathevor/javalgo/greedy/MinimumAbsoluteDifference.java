package com.vathevor.javalgo.greedy;

import java.util.Arrays;

/*
 * Consider an array of integers, arr=[0, 1, ... n].
 * We define the absolute difference between two elements,
 * a[i] and a[j] to be the absolute value of |a[i] - a[j]|
 *
 * Given an array of integers,
 * find and print the minimum absolute difference between any two elements in the array.
 * For example, given the array arr=[-2,2,4] we can create 3 pairs of numbers:
 *      [-2,2], [-2,4], [2,4]
 * The absolute differences for these pairs are
 *      |(-2)-2|=4      |(-2)-4|=6      |2-4|=2
 * The minimum absolute difference is 2.
 */
public class MinimumAbsoluteDifference {

    /**
     * @param arr
     * @return an integer that represents the minimum absolute difference between any pair of elements
     */
    static int minimumAbsoluteDifference(int[] arr) {
        if (arr.length < 2) return 0;
        Arrays.sort(arr);
        int diffMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i+1]);
            if(diff == 0) {
                return 0;
            }
            if (diff < diffMin) {
                diffMin = diff;
            }
        }
        return diffMin;
    }
}
