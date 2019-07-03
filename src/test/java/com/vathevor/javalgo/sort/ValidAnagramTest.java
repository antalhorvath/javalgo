package com.vathevor.javalgo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidAnagramTest {

    private ValidAnagram underTest = new ValidAnagram();

    @Test
    void shouldReturnTrue() {
        assertTrue(underTest.isAnagram("anagram", "nagaram"));
    }

    @Test
    void shouldReturnFalse() {
        assertTrue(underTest.isAnagram("rat", "car"));
    }
}