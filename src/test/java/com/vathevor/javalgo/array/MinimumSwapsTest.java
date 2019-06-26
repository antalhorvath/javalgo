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
}