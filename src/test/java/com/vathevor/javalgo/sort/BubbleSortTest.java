package com.vathevor.javalgo.sort;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @Test
    void testCase1() {
        BubbleSort.countSwaps(new int[]{6, 4, 1});
    }

    @Test
    void testCase2() {
        BubbleSort.countSwaps(new int[]{1, 2, 3});
    }

    @Test
    void testCase3() {
        BubbleSort.countSwaps(new int[]{3, 2, 1});
    }
}