package com.vathevor.javalgo.dp.stock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTwoTest {

    private static class TestCase {
        int[] input;
        int output;

        TestCase(int[] input, int output) {
            this.input = input;
            this.output = output;
        }
    }

    private BestTimeToBuyAndSellStockTwo underTest = new BestTimeToBuyAndSellStockTwo();

    @ParameterizedTest
    @MethodSource("testCases")
    void test(TestCase testCase) {
        int result = underTest.maxProfit(testCase.input);

        assertEquals(testCase.output, result, () -> Arrays.toString(testCase.input));
    }

    static Stream<TestCase> testCases() {
        int[] extremeInput = Stream.concat(
                IntStream.rangeClosed(0, 10000)
                        .boxed()
                        .sorted(Collections.reverseOrder()),

                IntStream.generate(() -> 0)
                        .limit(10000)
                        .boxed())
                .mapToInt(Integer::intValue)
                .toArray();

        return Stream.of(
                new TestCase(new int[]{7, 1, 5, 3, 6, 4}, 7),
                new TestCase(new int[]{1, 2, 3, 4, 5}, 4),
                new TestCase(new int[]{7, 6, 4, 3, 1}, 0),
                new TestCase(new int[]{2, 4, 1}, 2),
                new TestCase(extremeInput, 0)
        );
    }
}