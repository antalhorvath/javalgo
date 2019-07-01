package com.vathevor.javalgo.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidMountainTest {

    private static class TestCase {
        int[] input;
        boolean output;

        TestCase(int[] input, boolean output) {
            this.input = input;
            this.output = output;
        }
    }

    private ValidMountain underTest = new ValidMountain();

    @ParameterizedTest
    @MethodSource("testCases")
    void test(TestCase testCase) {
        boolean result = underTest.validMountainArray(testCase.input);

        Assertions.assertEquals(testCase.output, result);
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(new int[]{2, 1}, false),
                new TestCase(new int[]{3, 5, 5}, false),
                new TestCase(new int[]{0, 3, 2, 1}, true),
                new TestCase(new int[]{1, 3, 2}, true),
                new TestCase(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, false)
        );
    }
}