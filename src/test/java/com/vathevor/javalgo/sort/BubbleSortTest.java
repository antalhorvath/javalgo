package com.vathevor.javalgo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {

    @Test
    void testCase1() {
        int[] array = {6, 4, 1};

        BubbleSort.countSwaps(array);

        assertArrayEquals(new int[]{1, 4, 6}, array);
    }

    @Test
    void testCase2() {
        int[] array = {1, 2, 3};

        BubbleSort.countSwaps(array);

        assertArrayEquals(new int[]{1, 2, 3}, array);
    }

    @Test
    void testCase3() {
        int[] array = {3, 2, 1};

        BubbleSort.countSwaps(array);

        assertArrayEquals(new int[]{1, 2, 3}, array);
    }
}
