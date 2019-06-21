package com.vathevor.javalgo.general;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * #easy
 * Write a program that concatenates the numbers from 1 to 'length' into a string.
 * But for multiples of three concatenate “Fizz” instead of the number
 * and for the multiples of five concatenate “Buzz”.
 * For numbers which are multiples of both three and five print “FizzBuzz”.
 */
public class FizzBuzz {

    static String getFizzBuzz() {
        return IntStream.rangeClosed(1, 15)
                .mapToObj(number -> {
                    if (number % 3 == 0 && number % 5 == 0) return "FizzBuzz";
                    if (number % 3 == 0) return "Fizz";
                    if (number % 5 == 0) return "Buzz";
                    return String.valueOf(number);
                }).collect(Collectors.joining(" "));
    }
}
