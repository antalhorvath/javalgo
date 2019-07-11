package com.vathevor.javalgo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarkAndToysTest {

    @Test
    void testCase1() {
        int[] prices = {1, 2, 3, 4};

        int numberOfToys = MarkAndToys.maximumToys(prices, 7);

        assertEquals(3, numberOfToys);
    }

    @Test
    void testCase2() {
        int[] prices = {1, 12, 5, 111, 200, 1000, 10};

        int numberOfToys = MarkAndToys.maximumToys(prices, 50);

        assertEquals(4, numberOfToys);
    }
}