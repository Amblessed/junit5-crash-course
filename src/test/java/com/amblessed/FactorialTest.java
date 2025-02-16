package com.amblessed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 16-Feb-25
 */


class FactorialTest {

    @Test
    void factorialTestOfZero(){
        Factorial factorial = new Factorial();
        int actualResult = factorial.factorial(0);
        assertEquals(1, actualResult);
    }

    @Test
    void factorialTestOfOne(){
        Factorial factorial = new Factorial();
        int actualResult = factorial.factorial(1);
        assertEquals(1, actualResult);
    }

    @Test
    void factorialTest(){
        Factorial factorial = new Factorial();
        int actualResult = factorial.factorial(5);
        assertEquals(120, actualResult);
    }

}