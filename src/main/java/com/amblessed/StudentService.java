package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 16-Feb-25
 */


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public String[] getStudentNamesByDepartment(String department) {
        return students
                .stream()
                .filter(student -> student.getDepartment().equals(department))
                .map(Student::getName)
                .toArray(String[]::new);
    }

    public Integer[] getStudentIdsByDepartment(String department) {
        return students
                .stream()
                .filter(student -> student.getDepartment().equals(department))
                .map(Student::getId)
                .toArray(Integer[]::new);
    }

    public List<String> getStudentNamesListByDepartment(String department) {
        return students
                .stream()
                .filter(student -> student.getDepartment().equals(department))
                .map(Student::getName)
                .toList();
    }

    public List<Integer> getStudentIdsListByDepartment(String department) {
        return students
                .stream()
                .filter(student -> student.getDepartment().equals(department))
                .map(Student::getId)
                .toList();
    }


    /**
     * @param name Student name to search for
     * @return Student if  found, else throw StudentNotFoundException
     */
    public Student getStudentByName(String name) {
        return students
                .stream()
                .filter(student -> student.getName().equals(name))
                .findFirst().orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

}
