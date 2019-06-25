package com.vathevor.javalgo.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HourGlassSumTest {

    @ParameterizedTest
    @MethodSource("testCases")
    void testHourglassSum(TestCase testCase) {
        int output = HourGlassSum.hourglassSum(testCase.inputGrid);

        assertEquals(testCase.expectedOutput, output);
    }

    private static class TestCase {
        int[][] inputGrid;
        int expectedOutput;
    }

    static Stream<TestCase> testCases() {
        TestCase testCaseA = new TestCase();
        testCaseA.inputGrid = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        testCaseA.expectedOutput = 7;

        TestCase testCaseB = new TestCase();
        testCaseB.inputGrid = new int[][]{
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        testCaseB.expectedOutput = 28;

        TestCase testCaseC = new TestCase();
        testCaseC.inputGrid = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        testCaseC.expectedOutput = 19;

        return Stream.of(testCaseA, testCaseB, testCaseC);
    }
}
