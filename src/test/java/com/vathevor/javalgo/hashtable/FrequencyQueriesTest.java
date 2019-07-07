package com.vathevor.javalgo.hashtable;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.vathevor.javalgo.hashtable.FrequencyQueries.freqQuery;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequencyQueriesTest {

    @Test
    void testCase1() {
        List<List<Integer>> queries = asList(
                asList(1, 1),
                asList(2, 2),
                asList(3, 2),
                asList(1, 1),
                asList(1, 1),
                asList(2, 1),
                asList(3, 2)
        );

        assertEquals(asList(0, 1), freqQuery(queries));
    }

    @Test
    void testCase2() {
        List<List<Integer>> queries = asList(
                asList(1, 5),
                asList(1, 6),
                asList(3, 2),
                asList(1, 10),
                asList(1, 10),
                asList(1, 6),
                asList(2, 5),
                asList(3, 2)
        );

        assertEquals(asList(0, 1), freqQuery(queries));
    }

    @Test
    void testCase3() {
        List<List<Integer>> queries = asList(
                asList(3, 4),
                asList(2, 1003),
                asList(1, 16),
                asList(3, 1)
        );

        assertEquals(asList(0, 1), freqQuery(queries));
    }

    @Test
    void testCase4() {
        List<List<Integer>> queries = asList(
                asList(1, 3),
                asList(2, 3),
                asList(3, 2),
                asList(1, 4),
                asList(1, 5),
                asList(1, 5),
                asList(1, 4),
                asList(3, 2),
                asList(2, 4),
                asList(3, 2)
        );

        assertEquals(asList(0, 1, 1), freqQuery(queries));
    }
}