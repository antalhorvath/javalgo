package com.vathevor.javalgo.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestTest {

    @Test
    void test() {
        int k = 3;
        int[] elements = {4, 5, 8, 2};

        KthLargest kthLargest = new KthLargest(k, elements);
        
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));
    }
}