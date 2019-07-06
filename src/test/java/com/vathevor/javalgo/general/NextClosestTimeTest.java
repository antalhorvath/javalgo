package com.vathevor.javalgo.general;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextClosestTimeTest {

    private NextClosestTime underTest = new NextClosestTime();

    @Test
    void testCase1() {
        assertEquals("19:39", underTest.nextClosestTime("19:34"));
    }

    @Test
    void testCase2() {
        assertEquals("22:22", underTest.nextClosestTime("23:59"));
    }

    @Test
    void testCase3() {
        assertEquals("01:33", underTest.nextClosestTime("01:32"));
    }
}