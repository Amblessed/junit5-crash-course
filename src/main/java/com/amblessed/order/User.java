package com.amblessed.order;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 05-Mar-25
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {


    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public User(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
