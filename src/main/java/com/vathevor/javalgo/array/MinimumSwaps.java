package com.vathevor.javalgo.array;

/*
 * You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements.
 * You need to find the minimum number of swaps required to sort the array in ascending order.
 */
public class MinimumSwaps {

    static int minimumSwaps(int[] arr) {
        int numberOfSwaps = 0;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                int number = arr[i];
                if (number == i + 1) {
                    continue;
                }
                sorted = false;
                int temp = arr[number - 1];
                arr[number - 1] = number;
                arr[i] = temp;
                numberOfSwaps++;
            }
        }
        return numberOfSwaps;
    }
}
