package com.amblessed.parameterized;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 18-Feb-25
 */


import com.amblessed.Calculator;
import com.amblessed.Factorial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodSourceDemoTest {

    @ParameterizedTest
    @MethodSource({"argumentsProvider"})
    @DisplayName("Test the factorial of a number using MethodSource")
    void factorialTestUsingCsvSource(int number, int expectedResult) {
        Factorial factorial = new Factorial();
        long actualResult = factorial.factorial(number);
        assertEquals(expectedResult, actualResult);
    }


    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(4, 24),
                Arguments.of(5, 120),
                Arguments.of(6, 720)
        );
    }



}
