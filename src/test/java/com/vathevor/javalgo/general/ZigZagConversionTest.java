package com.vathevor.javalgo.general;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigZagConversionTest {

    @Test
    void testCase1() {
        String result = ZigZagConversion.convert("PAYPALISHIRING", 3);

        assertEquals("PAHNAPLSIIGYIR", result);
    }

    @Test
    void testCase2() {
        String result = ZigZagConversion.convert("PAYPALISHIRING", 4);

        assertEquals("PINALSIGYAHRPI", result);
    }
}