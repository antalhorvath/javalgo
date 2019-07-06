package com.vathevor.javalgo.hashtable;

import org.junit.jupiter.api.Test;

import static com.vathevor.javalgo.hashtable.SherlockAndAnagrams.sherlockAndAnagrams;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SherlockAndAnagramsTest {

    @Test
    void test() {
        assertEquals(4, sherlockAndAnagrams("abba"));
        assertEquals(0, sherlockAndAnagrams("abcd"));
        assertEquals(3, sherlockAndAnagrams("ifailuhkqq"));
        assertEquals(10, sherlockAndAnagrams("kkkk"));
    }
}