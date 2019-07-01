package com.vathevor.javalgo.dp.stock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {

    private static class TestCase {
        int[] input;
        int output;

        TestCase(int[] input, int output) {
            this.input = input;
            this.output = output;
        }
    }

    private BestTimeToBuyAndSellStock underTest = new BestTimeToBuyAndSellStock();

    @ParameterizedTest
    @MethodSource("testCases")
    void test(TestCase testCase) {
        int result = underTest.maxProfit(testCase.input);

        assertEquals(testCase.output, result, () -> Arrays.toString(testCase.input));
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(new int[]{7, 1, 5, 3, 6, 4}, 5),
                new TestCase(new int[]{7, 6, 4, 3, 1}, 0),
                new TestCase(new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 4),
                new TestCase(new int[]{1, 2, 3, 4, 5}, 4),
                new TestCase(new int[]{1, 2}, 1)
        );
    }
}