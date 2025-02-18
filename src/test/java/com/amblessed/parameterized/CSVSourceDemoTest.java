package com.amblessed.parameterized;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 18-Feb-25
 */


import com.amblessed.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVSourceDemoTest {

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2, 2", "3, 6", "4, 24", "5, 120", "6, 720"})
    @DisplayName("Test the factorial of a number using CSVSource")
     void factorialTestUsingCsvSource(int number, int expectedResult) {
        Calculator calculator = new Calculator();
        long actualResult = calculator.factorial(number);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/factorial_data.csv")
    @DisplayName("Test the factorial of a number using CSVFileSource")
    void factorialTestUsingCsvFileSource(int number, int expectedResult) {
        Calculator calculator = new Calculator();
        long actualResult = calculator.factorial(number);
        assertEquals(expectedResult, actualResult);
    }
}
