package com.vathevor.javalgo.general;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ParitySortedArrayTest {

    @Test
    void shouldReturn2413() {
        int[] input = new int[]{3, 1, 2, 4};

        int[] output = ParitySortedArray.getArraySortedByParity(input);

        assertArrayEquals(new int[]{2, 4, 1, 3}, output);
    }
}