package com.vathevor.javalgo.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifferencePairsTest {

    @Test
    void testCas1() {
        int target = 1;
        int[] integers = {1, 2, 3, 4};

        int numberOfPairs = DifferencePairs.pairs(target, integers);

        assertEquals(3, numberOfPairs);
    }

    @Test
    void testCas2() {
        int target = 2;
        int[] integers = {1, 5, 3, 4, 2};

        int numberOfPairs = DifferencePairs.pairs(target, integers);

        assertEquals(3, numberOfPairs);
    }
}