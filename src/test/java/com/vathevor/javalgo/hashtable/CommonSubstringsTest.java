package com.vathevor.javalgo.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonSubstringsTest {

    @Test
    void shouldReturnYes() {
        assertEquals("YES", CommonSubstrings.twoStrings("hello", "world"));
    }

    @Test
    void shouldReturnNo() {
        assertEquals("NO", CommonSubstrings.twoStrings("hi", "world"));
    }
}