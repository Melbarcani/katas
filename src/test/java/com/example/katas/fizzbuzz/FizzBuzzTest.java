package com.example.katas.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    private FizzBuzz fizzbuzz;

    @BeforeEach
    void setup() {
        fizzbuzz = new FizzBuzz();
    }

    @Test
    void shouldReturn1() {
        assertThat(fizzbuzz.run(1))
                .isEqualTo("1");
    }

    @Test
    void shouldReturn2() {
        assertThat(fizzbuzz.run(2))
                .isEqualTo("1 2");
    }

    @Test
    void shouldHandleFizzWhenMultipleOf3(){
        assertThat(fizzbuzz.run(3))
                .isEqualTo("1 2 fizz");
    }

    @Test
    void shouldHandleBuzzWhenMultipleOf5(){
        assertThat(fizzbuzz.run(5))
                .isEqualTo("1 2 fizz 4 buzz");
    }

    @Test
    void shouldHandleALongLimit(){
        assertThat(fizzbuzz.run(10))
                .isEqualTo("1 2 fizz 4 buzz fizz 7 8 fizz buzz");
    }

    @Test
    void shouldHandleFizzBuzz(){
        assertThat(fizzbuzz.run(15))
                .isEqualTo("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz");
    }
}