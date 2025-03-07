package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Mar-25
 */


import java.util.Objects;

public class StringUtils {

    public static boolean isPalindrome(String str) {
        if (Objects.isNull(str)) {
            return false;
        }
        String cleanedStr = str.replaceAll("[\\W]", "").toLowerCase();
        int length = cleanedStr.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanedStr.charAt(i) != cleanedStr.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
