package com.vathevor.javalgo.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RansomNoteTest {

    @Test
    void testCase1() {
        String result = RansomNote.checkMagazine("Attack at dawn", "attack at dawn");
        assertEquals("No", result);
    }

    @Test
    void testCase2() {
        String result = RansomNote.checkMagazine("give me one grand today night", "give one grand today");
        assertEquals("Yes", result);
    }

    @Test
    void testCase3() {
        String result = RansomNote.checkMagazine("two times three is not four", "two times two is four");
        assertEquals("No", result);
    }

    @Test
    void testCase4() {
        String result = RansomNote.checkMagazine("ive got a lovely bunch of coconuts", "ive got some coconuts");
        assertEquals("No", result);
    }
}