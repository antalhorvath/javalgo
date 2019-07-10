package com.vathevor.javalgo.general;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoStringTest {

    private static class TestCase {
        private String source;
        private String target;
        private boolean expectedOutput;

        TestCase(String source, String target, boolean expectedOutput) {
            this.source = source;
            this.target = target;
            this.expectedOutput = expectedOutput;
        }
    }

    private TwoString underTest = new TwoString();

    @ParameterizedTest
    @MethodSource("testCases")
    void test(TestCase testCase) {
        boolean output = underTest.canTargetBeConstructedFromSource(testCase.target, testCase.source);

        assertEquals(testCase.expectedOutput, output);
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(null, "cba", false),
                new TestCase("abc", null, false),
                new TestCase("abc", "cba", true),
                new TestCase("bcc", "cb", true),
                new TestCase("asdasd", "dsa", true),
                new TestCase("b", "bb", false)
        );
    }
}