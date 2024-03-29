package com.vathevor.javalgo.hashtable;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.vathevor.javalgo.hashtable.CountTriplets.countTriplets;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTripletsTest {

    @Test
    void testCase1() {
        List<Long> numbers = asList(1L, 2L, 2L, 4L);

        assertEquals(2, countTriplets(numbers, 2));
    }

    @Test
    void testCase2() {
        List<Long> numbers = asList(1L, 3L, 9L, 9L, 27L, 81L);

        assertEquals(6, countTriplets(numbers, 3));
    }

    @Test
    void testCase3() {
        List<Long> numbers = asList(1L, 5L, 5L, 25L, 125L);

        assertEquals(4, countTriplets(numbers, 5));
    }

    @Test
    void testCase4() {
        List<Long> numbers = LongStream.generate(() -> 1L).boxed()
                .limit(100)
                .collect(toList());

        assertEquals(161700, countTriplets(numbers, 1));
    }

    @Test
    void testCase5() {
        List<Long> numbers = LongStream.generate(() -> 1237L).boxed()
                .limit(100000)
                .collect(toList());

        assertEquals(166661666700000L, countTriplets(numbers, 1));
    }

    @Test
    void testCase6() {
        List<Long> numbers = readFromFile();

        assertEquals(2325652489L, countTriplets(numbers, 3));
    }

    private List<Long> readFromFile() {
        Path path;
        try {
            path = Paths.get(getClass().getClassLoader()
                    .getResource("com.vathevor.javalgo.hashtable/large_input.txt")
                    .toURI());

            return Files.lines(path)
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(Long::valueOf)
                    .collect(Collectors.toList());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
