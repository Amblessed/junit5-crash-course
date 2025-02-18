package com.amblessed.parameterized;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 18-Feb-25
 */


import com.amblessed.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValueSourceDemoTest {



    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @DisplayName("Test if number is even" )
    void isEvenTest(int number) {
        Calculator calculator = new Calculator();
        boolean result = calculator.isEven(number);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "JUnit5", "Parameterized", "Test"})
    @DisplayName("Test if number is even" )
    void isEvenTest(String str) {
        assertNotNull(str);
    }
}
