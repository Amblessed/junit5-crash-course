package com.amblessed;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 16-Feb-25
 */


class StudentServiceTest {

    @Test
    void getStudentsTestAssertTrue(){
        StudentService studentService = new StudentService();
        List<Student> listOfStudents = studentService.getStudents();
        boolean actualResult = listOfStudents.isEmpty();
        assertTrue(actualResult);
    }

    @Test
    void getStudentsTestAssertFalse(){
        StudentService studentService = new StudentService();
        Faker faker = new Faker();
        Student student = new Student(1, faker.name().fullName());
        List<Student> listOfStudents = studentService.getStudents();
        studentService.addStudent(student);
        boolean actualResult = listOfStudents.isEmpty();
        assertFalse(actualResult, "List should not be empty");
    }

}