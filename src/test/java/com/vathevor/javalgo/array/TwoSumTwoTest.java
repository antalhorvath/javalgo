package com.vathevor.javalgo.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTwoTest {

    private TwoSumTwo underTest = new TwoSumTwo();

    @Test
    void testCase1() {
        int[] result = underTest.twoSum(new int[]{2, 7, 11, 15}, 9);

        Assertions.assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testCase2() {
        int[] result = underTest.twoSum(new int[]{-1, 0}, -1);

        Assertions.assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testCase3() {
        int[] result = underTest.twoSum(new int[]{0, 0, 3, 4}, 0);

        Assertions.assertArrayEquals(new int[]{1, 2}, result);
    }
}