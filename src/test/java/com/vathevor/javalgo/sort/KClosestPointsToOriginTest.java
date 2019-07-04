package com.vathevor.javalgo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KClosestPointsToOriginTest {

    private KClosestPointsToOrigin underTest = new KClosestPointsToOrigin();

    @Test
    void testCase1() {
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int k = 1;

        int[][] result = underTest.kClosest(points, k);

        int[][] expectedResult = new int[][]{{-2, 2}};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void testCase2() {
        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        int[][] result = underTest.kClosest(points, k);

        int[][] expectedResult = new int[][]{{3, 3}, {-2, 4}};
        assertArrayEquals(expectedResult, result);
    }
}