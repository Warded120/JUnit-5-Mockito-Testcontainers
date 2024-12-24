package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Simple. class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
public class DemoUtilsTest {
    DemoUtils demoUtils;

    @BeforeEach
    void beforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("equals and not equals")
    void testEqualsAndNotEquals() {
        int num1 = 2;
        int num2 = 3;
        int expectedResult = 5;

        assertEquals(expectedResult, demoUtils.add(num1, num2), num1 + "+" + num2 + " must equal to " + expectedResult);
        assertNotEquals(-5, demoUtils.add(num1, num2), num1 + "+" + num2 + " must not equal to " + -5);
    }

    @Test
    @DisplayName("multiply test")
    void testMultiply() {
        int num1 = 2;
        int num2 = 6;
        int expectedResult = 12;

        assertEquals(expectedResult, demoUtils.multiply(num1, num2), num1 + "*" + num2 + " must equal to " + expectedResult)   ;
    }

    @Test
    @DisplayName("test null and not null")
    void testNullAndNotNull() {
        String str1 = null;
        String str2 = "someStr";

        assertNull(demoUtils.checkNull(str1), "Must be null");
        assertNotNull(demoUtils.checkNull(str2), "Must not be null");
    }

    @Test
    @DisplayName("assert same and not same")
    void testSameAndNotSame() {
        String str0 = "someStr";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Must be the same");
        assertNotSame(demoUtils.getAcademy(), str0, "Must not be the same");
    }

    @Test
    @DisplayName("assert true and false")
    void testFalseAndTrue() {
        int grade1 = 10;
        int grade2 = 5;

        assertTrue(demoUtils.isGreater(grade1, grade2), "Must be true");
        assertFalse(demoUtils.isGreater(grade2, grade1), "Must be false");
    }

    @Test
    @DisplayName("array equals")
    void testArrayEquals() {
        String[] arr1 = {"A", "B", "C"};

        assertArrayEquals(arr1, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be equal");
    }

    @Test
    @DisplayName("iterable equals")
    void testIterableEquals() {
        List<String> list = List.of("luv", "2", "code");

        assertIterableEquals(list, demoUtils.getAcademyInList(), "iterables must be equal");
    }

    @Test
    @DisplayName("lines match")
    void testLinesMatch() {
        List<String> list = List.of("luv", "2", "code");

        assertIterableEquals(list, demoUtils.getAcademyInList(), "lines must match");
    }

    @Test
    @DisplayName("test throws")
    void testThrows() {
        int smthThatThrows = -1;
        int smthThatDoesNotThrow = 1;

        assertThrows(Exception.class, () -> {demoUtils.throwException (smthThatThrows);}, "must throw exception");
        assertDoesNotThrow(() -> {demoUtils.throwException (smthThatDoesNotThrow);}, "must not throw exception");
    }

    @Test
    @DisplayName("check timeout")
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3),
                () -> {demoUtils.checkTimeout();}, "too slow");
    }
}
