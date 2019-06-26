package com.vathevor.javalgo.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayManipulationTest {

    @Test
    void testCase1() {
        int[][] queries = {
                {1, 5, 3},
                {4, 8, 7},
                {6, 9, 1}
        };

        long output = ArrayManipulation.arrayManipulation(10, queries);

        assertEquals(10, output);
    }

    @Test
    void testCase2() {
        int[][] queries = {
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        };

        long output = ArrayManipulation.arrayManipulation(5, queries);

        assertEquals(200, output);
    }
}