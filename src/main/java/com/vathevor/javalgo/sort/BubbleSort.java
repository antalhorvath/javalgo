package com.vathevor.javalgo.sort;

/*
 * Given an array of integers,
 * sort the array in ascending order using the Bubble Sort algorithm below.
 * Once sorted, print the following three lines:
 *      Array is sorted in numSwaps swaps., where numSwaps is the number of swaps that took place.
 *      First Element: firstElement, where firstElement is the first element in the sorted array.
 *      Last Element: lastElement, where lastElement is the last element in the sorted array.
 */
public class BubbleSort {

    // Complete the countSwaps function below. It should print the three lines required, then return.
    static void countSwaps(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    static void swap(int[] a, int i, int j) {

    }
}
