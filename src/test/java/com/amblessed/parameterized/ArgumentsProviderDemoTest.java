package com.amblessed.parameterized;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 19-Feb-25
 */


import com.amblessed.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgumentsProviderDemoTest {


    @ParameterizedTest
    @ArgumentsSource(FactorialArgumentsProvider.class)
    @DisplayName("Test the factorial of a number using ArgumentsSource")
    void factorialTestUsingCsvSource(int number, int expectedResult) {
        Calculator calculator = new Calculator();
        long actualResult = calculator.factorial(number);
        assertEquals(expectedResult, actualResult);
    }


}
