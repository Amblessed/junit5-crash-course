package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 18-Feb-25
 */


public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
    }
}
