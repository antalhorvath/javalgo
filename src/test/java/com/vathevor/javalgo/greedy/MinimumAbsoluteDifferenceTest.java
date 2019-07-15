package com.vathevor.javalgo.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAbsoluteDifferenceTest {

    @Test
    void testCase1() {
        int[] input = {-2, 2, 4};

        int output = MinimumAbsoluteDifference.minimumAbsoluteDifference(input);

        assertEquals(2, output);
    }

    @Test
    void testCase2() {
        int[] input = {3, -7, 0};

        int output = MinimumAbsoluteDifference.minimumAbsoluteDifference(input);

        assertEquals(3, output);
    }

    @Test
    void testCase3() {
        int[] input = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};

        int output = MinimumAbsoluteDifference.minimumAbsoluteDifference(input);

        assertEquals(1, output);
    }

    @Test
    void testCase4() {
        int[] input = {1, -3, 71, 68, 17};

        int output = MinimumAbsoluteDifference.minimumAbsoluteDifference(input);

        assertEquals(3, output);
    }
}