package com.vathevor.javalgo.array;

/*
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * Recall that A is a mountain array if and only if:
 *  - A.length >= 3
 *  - There exists some i with 0 < i < A.length - 1 such that:
 *      - A[0] < A[1] < ... A[i-1] < A[i]
 *      - A[i] > A[i+1] > ... > A[A.length - 1]
 */
public class ValidMountain {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int i = 0;

        while (i + 1 < A.length && A[i] < A[i + 1]) {
            i++;
        }

        if (i == 0) {
            return false;
        }

        while (i + 1 < A.length && A[i + 1] < A[i]) {
            i++;
        }

        return i == A.length - 1 && A[i] < A[i - 1];
    }
}
