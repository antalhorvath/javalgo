package com.vathevor.javalgo.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ParitySortedArrayTwoTest {

    private ParitySortedArrayTwo underTest = new ParitySortedArrayTwo();

    @Test
    void test() {
        int[] result = underTest.sortArrayByParityII(new int[]{4, 2, 5, 7});

        boolean solution1 = Arrays.equals(new int[]{4, 7, 2, 5}, result);
        boolean solution2 = Arrays.equals(new int[]{2, 5, 4, 7}, result);
        boolean solution3 = Arrays.equals(new int[]{2, 7, 4, 5}, result);
        boolean solution4 = Arrays.equals(new int[]{4, 5, 2, 7}, result);

        assertTrue(solution1 || solution2 || solution3 || solution4);
    }
}