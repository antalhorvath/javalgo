package com.vathevor.javalgo.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftRotationTest {

    @Test
    void testCase1() {
        int[] input = {1, 2, 3, 4, 5};

        int[] output = LeftRotation.rotLeft(input, 4);

        int[] expectedOutput = {5, 1, 2, 3, 4};
        assertArrayEquals(expectedOutput, output);
    }
}