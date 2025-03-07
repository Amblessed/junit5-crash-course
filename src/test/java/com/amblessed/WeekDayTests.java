package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 05-Mar-25
 */


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekDayTests {

    @Test
    @EnabledIf("isWeekday")
    void weekdays(){
        System.out.println("This test runs only on weekdays");
    }

    @Test
    @DisabledIf("isWeekday")
    void weekends(){
        System.out.println("This test runs only on weekends");
    }


    private boolean isWeekday(){
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }
}
