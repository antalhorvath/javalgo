package com.vathevor.javalgo.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSwapsTest {

    @Test
    void testCase1() {
        int[] input = {1, 3, 5, 2, 4, 6, 7};

        int output = MinimumSwaps.minimumSwaps(input);

        assertEquals(3, output);
    }

    @Test
    void testCase2() {
        int[] input = {4, 3, 1, 2};

        int output = MinimumSwaps.minimumSwaps(input);

        assertEquals(3, output);
    }

    @Test
    void testCase3() {
        int[] input = {3, 7, 6, 9, 1, 8, 10, 4, 2, 5};


        int output = MinimumSwaps.minimumSwaps(input);

        assertEquals(9, output);
    }

    @Test
    void testCase4() {
        int[] input = {2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34,
                42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19};

        int output = MinimumSwaps.minimumSwaps(input);

        assertEquals(46, output);
    }
}