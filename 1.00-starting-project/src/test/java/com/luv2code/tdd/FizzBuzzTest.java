package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    @ParameterizedTest
    @MethodSource
    @Order(1)
    void divisibleByThree(int n) {
        assertEquals("Fizz", FizzBuzz.compute(n), "Must return Fizz");
    }

    @ParameterizedTest
    @MethodSource
    @Order(2)
    void divisibleByFive(int n) {
        assertEquals("Buzz", FizzBuzz.compute(5), "Must return Fizz");
    }

    @ParameterizedTest
    @MethodSource
    @Order(3)
    void divisibleByThreeAndFive(int n) {
        assertEquals("FizzBuzz", FizzBuzz.compute(15), "Must return Fizz");
    }

    @ParameterizedTest
    @MethodSource
    @Order(4)
    void notDivisible(int n) {
        assertEquals("7", FizzBuzz.compute(7), "Must return 7");
    }

    static Stream<Arguments> divisibleByThree() {
        return Stream.of(3, 6, 9, 12, 18).map(Arguments::of);
    }

    static Stream<Arguments> divisibleByFive() {
        return Stream.of(5, 10, 20, 25).map(Arguments::of);
    }

    static Stream<Arguments> divisibleByThreeAndFive() {
        return Stream.of(15, 30, 45, 60).map(Arguments::of);
    }

    static Stream<Arguments> notDivisible() {
        return Stream.of(1, 2, 4, 7, 8, 11, 13, 17).map(Arguments::of);
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(5)
    void smallDataTest(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Must return " + value);
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(6)
    void mediumDataTest(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Must return " + value);
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(7)
    void largeDataTest(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value), "Must return " + value);
    }
}
