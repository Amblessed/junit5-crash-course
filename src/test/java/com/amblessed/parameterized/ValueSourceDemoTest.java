package com.amblessed.parameterized;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 18-Feb-25
 */


import com.amblessed.Calculator;
import com.amblessed.StringUtils;
import com.amblessed.validator.EmailValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ValueSourceDemoTest {


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @DisplayName("Test if number is even" )
    void isEvenTest(int number) {
        Calculator calculator = new Calculator();
        boolean result = calculator.isEven(number);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "JUnit5", "Parameterized", "Test"})
    @DisplayName("Test String is not null" )
    void isEvenTest(String str) {
        assertNotNull(str);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "racecar", "Racecar"})
    @DisplayName("Test String is a Palindrome" )
    void isPalindromeTest(String str) {
        assertTrue(StringUtils.isPalindrome(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "JUnit5", "Java"})
    @DisplayName("Test String is not a Palindrome")
    @Timeout(1)
    void isNotPalindromeTest(String str) {
        assertFalse(StringUtils.isPalindrome(str));
    }

    @Test
    @DisplayName("Test Null String")
    @Timeout(2)
    void isNotPalindromeNullTest() {
        assertFalse(StringUtils.isPalindrome(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"user@example.com", "user.name@example.com", "user123@example.com", "user_name@example.com"})
    @DisplayName("Test Email is valid")
    @Timeout(2)
    void isValidEmailTest(String email) {
        assertTrue(EmailValidator.isValid(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"user@", "@example.com", "user@.com", "user@exa_mple.com", "user@example."})
    @DisplayName("Test Email is not valid")
    @Timeout(2)
    void isNotValidEmailTest(String email) {
        assertFalse(EmailValidator.isValid(email));
    }
}
