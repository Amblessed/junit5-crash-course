package com.amblessed.tdd;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Mar-25
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTest {

    private static Task task;
    private static final String DESCRIPTION = "Play with the kids";

    @BeforeEach
    void setUp() {
        task = new Task(DESCRIPTION);
    }



    @Test
    void newTaskHasAnId() {
        assertNotNull(task.getId());
    }


    @Test
    void testGetDescription() {
        String description = task.getDescription();
        assertNotNull(task.getDescription());
        assertEquals(DESCRIPTION, description);

    }

    @Test
    void testSetDescription() {
        task.setDescription("Clean the Car");
        String description = task.getDescription();
        assertNotNull(description);
        assertEquals("Clean the Car", description);

    }
}
