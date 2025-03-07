package com.amblessed.tdd;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Mar-25
 */


import java.util.*;

public class TaskManager {

    private final Map<Integer, Task> tasks;

    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        this.tasks.put(task.getId(), task);
    }

    public boolean exists(int taskId) {
        return this.tasks.containsKey(taskId);
    }


    public int count() {
        return this.tasks.size();
    }

    public void removeTask(int taskId) {
        this.tasks.remove(taskId);
    }

    public Task retrieveTask(int taskId) {
        return this.tasks.get(taskId);
    }



}
