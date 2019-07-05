package com.vathevor.javalgo.sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AmazonOrderingTest {

    @Test
    void testCase() {
        List<String> orders = asList(
                "ni3 jog mid bet",
                "wz3 44 66 128",
                "b2 alps gow pair",
                "x4 34 12 17"
        );

        List<String> expected = asList(
                "b2 alps gow pair",
                "ni3 jog mid bet",
                "wz3 44 66 128",
                "x4 34 12 17"
        );

        List<String> result = new AmazonOrdering().getPrioritizedOrders(4, orders);

        assertEquals(expected, result);
    }

}