package com.amblessed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 16-Feb-25
 */


class CalculatorTest {

    @Test
    void testAddMethod() {

        //Arrange
        Calculator calculator = new Calculator();

        //Act
        int actualResult = calculator.add(20, 30);

        //Assert
        assertEquals(50, actualResult);
    }

}