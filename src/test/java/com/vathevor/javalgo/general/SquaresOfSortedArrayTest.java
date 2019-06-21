package com.vathevor.javalgo.general;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SquaresOfSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testCases")
    void shouldReturnSquareOfElementsInAcendingOrder(TestCase testCase) {
        int[] result = SquaresOfSortedArray.sortedSquares(testCase.input);

        assertArrayEquals(testCase.expectedOutput, result);
    }

    private static class TestCase {
        int[] input;
        int[] expectedOutput;

        TestCase(int[] input, int[] expectedOutput) {
            this.input = input;
            this.expectedOutput = expectedOutput;
        }
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}),
                new TestCase(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121})
        );
    }
}