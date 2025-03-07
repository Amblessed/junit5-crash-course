package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Mar-25
 */


public enum UserRole {

    ADMIN, MODERATOR, USER, GUEST;

    public boolean hasWritePermission() {
        return switch (this) {
            case ADMIN, MODERATOR -> true;
            case USER, GUEST -> false;
        };
    }
}
