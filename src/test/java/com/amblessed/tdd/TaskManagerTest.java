package com.amblessed.tdd;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Mar-25
 */


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private TaskManager taskManager;
    private Task task;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        task = new Task("Read a book");
    }

    @AfterEach
    void tearDown() {
        taskManager = null;
        task = null;
    }

    @Test
    void testTaskManagerExists() {
        assertNotNull(taskManager);
        assertNotNull(task);
        assertEquals(0, taskManager.count());
    }


    @Test
    void testAddTask() {
        //Arrange

        //Act
        taskManager.addTask(task);

        //Assert
        assertTrue(taskManager.exists(task.getId()));
        assertEquals(1, taskManager.count());

    }



    @Test
    void addTask_duplicateTasks() {
        //Arrange
        Task task1 = new Task("Go Hiking");
        Task task2 = new Task("Catch up with friends");

        //Act
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        //Assert
        assertTrue(taskManager.exists(task1.getId()));
        assertTrue(taskManager.exists(task2.getId()));
        assertEquals(2, taskManager.count());
    }

    @Test
    void testRemoveTask() {
        //Arrange

        //Act
        taskManager.addTask(task);
        int previousCount = taskManager.count();
        taskManager.removeTask(task.getId());

        //Assert
        assertFalse(taskManager.exists(task.getId()));
        assertEquals(previousCount-1, taskManager.count());
    }

    @Test
    void testRetrieveTask() {
        //Arrange

        //Act
        taskManager.addTask(task);
        Task retrievedTask = taskManager.retrieveTask(task.getId());

        //Assert
        assertEquals(task, retrievedTask);
    }
}
