package com.amblessed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 16-Feb-25
 */


class FactorialTest {

    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }


    @Test
    void factorialTestOfZero(){
        int actualResult = factorial.factorial(0);
        assertEquals(1, actualResult);
    }

    @Test
    void factorialTestOfOne(){
        int actualResult = factorial.factorial(1);
        assertEquals(1, actualResult);
    }

    @Test
    void factorialTest(){
        int actualResult = factorial.factorial(5);
        assertEquals(120, actualResult);
    }

    @Test
    void factorialTestOfNegativeNumber(){
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial(-1));
    }

}