package com.amblessed.parameterized;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 18-Feb-25
 */


import com.amblessed.Factorial;
import com.amblessed.TemperatureConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVSourceDemoTest {

    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }

    @AfterEach
    void tearDown() {
        factorial = null;
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2, 2", "3, 6", "4, 24", "5, 120", "6, 720"})
    @DisplayName("Test the factorial of a number using CSVSource")
     void factorialTestUsingCsvSource(int number, int expectedResult) {
        long actualResult = factorial.factorial(number);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/factorial_data.csv")
    @DisplayName("Test the factorial of a number using CSVFileSource")
    void factorialTestUsingCsvFileSource(int number, int expectedResult) {
        long actualResult = factorial.factorial(number);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"0, 32.0", "100, 212.0", "-40, -40.0", "37, 98.6", "25, 77.0", "-10, 14.0"})
    @DisplayName("Test the TemperatureConverter using CSVSource")
    void celsiusToFahrenheit(int celsius, double expectedFahrenheit) {
        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius));
    }
}
