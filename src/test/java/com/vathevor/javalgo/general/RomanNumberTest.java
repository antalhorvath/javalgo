package com.vathevor.javalgo.general;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumberTest {

    @ParameterizedTest
    @MethodSource("testCases")
    void test(TestCase testCase) {
        RomanNumber actual = RomanNumber.valueOf(testCase.integer);

        assertEquals(testCase.romanNumber, actual.getValue());
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(1, "I"),
                new TestCase(2, "II"),
                new TestCase(3, "III"),
                new TestCase(4, "IV"),
                new TestCase(5, "V"),
                new TestCase(6, "VI"),
                new TestCase(9, "IX"),
                new TestCase(10, "X"),
                new TestCase(40, "XL"),
                new TestCase(50, "L"),
                new TestCase(60, "LX"),
                new TestCase(70, "LXX"),
                new TestCase(80, "LXXX"),
                new TestCase(90, "XC"),
                new TestCase(100, "C"),
                new TestCase(400, "CD"),
                new TestCase(500, "D"),
                new TestCase(900, "CM"),
                new TestCase(1000, "M"),
                new TestCase(2000, "MM")
        );
    }

    private static class TestCase {

        private Integer integer;
        private String romanNumber;

        TestCase(Integer integer, String romanNumber) {
            this.integer = integer;
            this.romanNumber = romanNumber;
        }
    }
}