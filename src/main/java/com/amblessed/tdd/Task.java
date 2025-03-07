package com.amblessed.tdd;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Mar-25
 */


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private Integer id;
    private String description;
    private static int counter = 0;

    public Task(String description){
        this.description = description;
        this.id = counter++;
    }


}
