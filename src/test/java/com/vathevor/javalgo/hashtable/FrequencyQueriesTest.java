package com.vathevor.javalgo.hashtable;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.vathevor.javalgo.hashtable.FrequencyQueries.freqQuery;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequencyQueriesTest {

    @Test
    void testCase1() {
        List<int[]> queries = asList(
                new int[]{1, 1},
                new int[]{2, 2},
                new int[]{3, 2},
                new int[]{1, 1},
                new int[]{1, 1},
                new int[]{2, 1},
                new int[]{3, 2}
        );

        assertEquals(asList(0, 1), freqQuery(queries));
    }

    @Test
    void testCase2() {
        List<int[]> queries = asList(
                new int[]{1, 5},
                new int[]{1, 6},
                new int[]{3, 2},
                new int[]{1, 10},
                new int[]{1, 10},
                new int[]{1, 6},
                new int[]{2, 5},
                new int[]{3, 2}
        );

        assertEquals(asList(0, 1), freqQuery(queries));
    }

    @Test
    void testCase3() {
        List<int[]> queries = asList(
                new int[]{3, 4},
                new int[]{2, 1003},
                new int[]{1, 16},
                new int[]{3, 1}
        );

        assertEquals(asList(0, 1), freqQuery(queries));
    }

    @Test
    void testCase4() {
        List<int[]> queries = asList(
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{3, 2},
                new int[]{1, 4},
                new int[]{1, 5},
                new int[]{1, 5},
                new int[]{1, 4},
                new int[]{3, 2},
                new int[]{2, 4},
                new int[]{3, 2}
        );

        assertEquals(asList(0, 1, 1), freqQuery(queries));
    }
}