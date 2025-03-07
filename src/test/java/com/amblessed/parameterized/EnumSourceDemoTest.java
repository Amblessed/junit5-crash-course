package com.amblessed.parameterized;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 18-Feb-25
 */


import com.amblessed.Calculator;
import com.amblessed.Days;
import com.amblessed.UserRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnumSourceDemoTest {

    @ParameterizedTest
    @EnumSource(value = Days.class, names = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"})
    @DisplayName("Test if day is a week day" )
    void isWeekDayTest(Days day) {
        Calculator calculator = new Calculator();
        boolean result = calculator.isWeekday(day);
        assertTrue(result);
    }


    @ParameterizedTest
    @EnumSource(value = UserRole.class, names = { "ADMIN", "MODERATOR" })
    public void rolesWithWritePermission(UserRole role) {
        assertTrue(role.hasWritePermission());
    }

    @ParameterizedTest
    @EnumSource(value = UserRole.class, names = { "USER", "GUEST" })
    public void rolesWithoutWritePermission(UserRole role) {
        assertFalse(role.hasWritePermission());
    }

}
