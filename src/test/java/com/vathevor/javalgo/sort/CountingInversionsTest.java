package com.vathevor.javalgo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingInversionsTest {

    @Test
    void testCase1() {
        int[] array = {2, 4, 1};

        long result = CountingInversions.countInversions(array);

        assertEquals(2, result);
    }

    @Test
    void testCase2() {
        int[] array = {1, 1, 1, 2, 2};

        long result = CountingInversions.countInversions(array);

        assertEquals(0, result);
    }

    @Test
    void testCase3() {
        int[] array = {2, 1, 3, 1, 2};

        long result = CountingInversions.countInversions(array);

        assertEquals(4, result);
    }
}