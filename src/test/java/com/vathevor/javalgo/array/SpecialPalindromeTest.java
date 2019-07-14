package com.vathevor.javalgo.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialPalindromeTest {

    @Test
    void testCase1() {
        String input = "asasd";

        long output = SpecialPalindrome.substrCount(input.length(), input);

        assertEquals(7, output);
    }

    @Test
    void testCase2() {
        String input = "abcbaba";

        long output = SpecialPalindrome.substrCount(input.length(), input);

        assertEquals(10, output);
    }

    @Test
    void testCase3() {
        String input = "aaaa";

        long output = SpecialPalindrome.substrCount(input.length(), input);

        assertEquals(10, output);
    }
}