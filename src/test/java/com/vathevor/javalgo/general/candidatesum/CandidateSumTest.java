package com.vathevor.javalgo.general.candidatesum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class CandidateSumTest {

    CandidateSum underTest;

    @BeforeEach
    void setUp() {
        initializeUnderTest();
    }

    abstract void initializeUnderTest();

    @ParameterizedTest
    @MethodSource("testCases")
    void test(TestCase testCase) {
        List<List<Integer>> output = underTest.combinationSum(testCase.input.integers, testCase.input.target);

        assertTrue(output.containsAll(testCase.expectedOutput));
    }

    private static class Input {
        int[] integers;
        int target;

        Input(int[] integers, int target) {
            this.integers = integers;
            this.target = target;
        }
    }

    private static class TestCase {
        Input input;
        List<List<Integer>> expectedOutput;

        TestCase(Input input, List<List<Integer>> expectedOutput) {
            this.input = input;
            this.expectedOutput = expectedOutput;
        }
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(
                        new Input(new int[]{2, 3, 6, 7}, 7),
                        asList(
                                singletonList(7),
                                asList(2, 2, 3)
                        )),
                new TestCase(new Input(new int[]{2, 3, 5}, 8),
                        asList(
                                asList(2, 2, 2, 2),
                                asList(2, 3, 3),
                                asList(3, 5)
                        )));
    }
}