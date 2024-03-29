package com.vathevor.javalgo.sort;

/*
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *      Input: [4,2,5,7]
 *      Output: [4,5,2,7]
 *      Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * Note:
 *      2 <= A.length <= 20000
 *      A.length % 2 == 0
 *      0 <= A[i] <= 1000
 */
public class ParitySortedArrayTwo {

    public int[] sortArrayByParityII(int[] A) {
        if (A.length < 2) return A;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                if (A[i] % 2 != 0) {
                    for (int j = i + 1; j < A.length; j++) {
                        if (A[j] % 2 == 0) {
                            swap(A, i, j);
                            break;
                        }
                    }
                }
            } else {
                if (A[i] % 2 == 0) {
                    for (int j = i + 1; j < A.length; j++) {
                        if (A[j] % 2 != 0) {
                            swap(A, i, j);
                            break;
                        }
                    }
                }
            }

        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        A[i] = A[i] + A[j];
        A[j] = A[i] - A[j];
        A[i] = A[i] - A[j];
    }
}
