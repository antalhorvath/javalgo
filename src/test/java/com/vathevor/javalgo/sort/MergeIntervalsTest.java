package com.vathevor.javalgo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeIntervalsTest {

    private MergeIntervals underTest = new MergeIntervals();

    @Test
    void testCase1() {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] result = underTest.merge(input);

        int[][] output = {{1, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(output, result);
    }

    @Test
    void testCase2() {
        int[][] input = {{1, 4}, {4, 5}};

        int[][] result = underTest.merge(input);

        int[][] output = {{1, 5}};
        assertArrayEquals(output, result);
    }

    @Test
    void testCase3() {
        int[][] input = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};

        int[][] result = underTest.merge(input);

        int[][] output = {{1, 3}, {4, 7}};
        assertArrayEquals(output, result);

    }
}