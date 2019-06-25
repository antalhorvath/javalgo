package com.vathevor.javalgo.array;

/*
 * Given a 6x6 2D array.
 * An hourglass looks like the following
 *
 * a b c
 *   d
 * e f g
 *
 * There are 16 hourglasses in the given array.
 * Calculate the hourglass sum for every hourglass in the array and return the maximum value.
 */
public class HourGlassSum {

    private static final int[][] HOURGLASS = new int[][]{
            {1, 1, 1},
            {0, 1, 0},
            {1, 1, 1}
    };

    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int sum = getSumOfHourglassInPosition(arr, col, row);
                max = max < sum ? sum : max;
            }
        }
        return max;
    }

    private static int getSumOfHourglassInPosition(int[][] arr, int x, int y) {
        int sum = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sum += arr[row + y][col + x] * HOURGLASS[row][col];
            }
        }
        return sum;
    }
}
