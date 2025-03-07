package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 26-Feb-25
 */


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    @Test
    public void testCelsiusZeroToFahrenheit() {
        // Test case for converting Celsius to Fahrenheit
        double celsius = 0;
        double expectedFahrenheit = 32.0;
        double actualFahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001);
    }

    @Test
    public void testCelsius25ToFahrenheit() {
        // Test case for converting Celsius to Fahrenheit
        double celsius = 25.0;
        double expectedFahrenheit = 77.0;
        double actualFahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.001);
    }

    @Test
    public void testCelsiusLargeNegativeNumberToFahrenheit() {
        // Test case for converting Celsius to Fahrenheit
        double celsius = -285.0;
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.celsiusToFahrenheit(celsius));
        assertEquals("Temperature cannot be below absolute zero (-273.15°C)", illegalArgumentException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-300, -273.18, -273.16, -290})
    @DisplayName("Test Celsius too low" )
    void testCelsiusToFahrenheit_celsiusTooLow(Double celsius) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.celsiusToFahrenheit(celsius));
        assertEquals("Temperature cannot be below absolute zero (-273.15°C)", illegalArgumentException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-273.14, -273.15})
    @DisplayName("Test Celsius edge cases" )
    void testCelsiusToFahrenheit_edgeCases(Double celsius) {
        assertDoesNotThrow(() -> TemperatureConverter.celsiusToFahrenheit(celsius));
    }

    @Test
    public void testFahrenheitToCelsius() {
        // Test case for converting Fahrenheit to Celsius
        double fahrenheit = 212.0;
        double expectedCelsius = 100.0;
        double actualFahrenheit = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
        assertEquals(expectedCelsius, actualFahrenheit, 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-459.68, -460.88, -558.23, -1000.65})
    @DisplayName("Test Fahrenheit too low" )
    void testFahrenheitToCCelsius_fahrenheitTooLow(Double fahrenheit) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.fahrenheitToCelsius(fahrenheit));
        assertEquals("Temperature cannot be below absolute zero (-459.67°F)", illegalArgumentException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-459.66, -459.67})
    @DisplayName("Test Fahrenheit edge cases" )
    void testFahrenheitToCelsius_edgeCases(Double fahrenheit) {
        assertDoesNotThrow(() -> TemperatureConverter.fahrenheitToCelsius(fahrenheit));
    }
}
