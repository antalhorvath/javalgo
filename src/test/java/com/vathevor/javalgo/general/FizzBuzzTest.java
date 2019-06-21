package com.vathevor.javalgo.general;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @Test
    void shouldReturnFizzBuzz() {
        String result = FizzBuzz.getFizzBuzz();

        assertEquals("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz", result);
    }
}