package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 16-Feb-25
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private String department;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
