package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 16-Feb-25
 */


public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isWeekday(Days day) {
        return day != Days.SATURDAY && day != Days.SUNDAY;
    }

}
