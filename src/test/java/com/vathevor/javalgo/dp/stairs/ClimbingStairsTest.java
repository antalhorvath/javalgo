package com.vathevor.javalgo.dp.stairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {

    private static class TestCase {
        int input;
        int output;

        TestCase(int input, int output) {
            this.input = input;
            this.output = output;
        }
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testBruteForceImplementation(TestCase testCase) {
        ClimbingStairs underTest = new BruteForceClimbingStairs();

        int result = underTest.climbStairs(testCase.input);

        assertEquals(testCase.output, result);
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(0, 1),
                new TestCase(1, 1),
                new TestCase(2, 2),
                new TestCase(3, 3),
                new TestCase(4, 5),
                new TestCase(5, 8)
        );
    }
}