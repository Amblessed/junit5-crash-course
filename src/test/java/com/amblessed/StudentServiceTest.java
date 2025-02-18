package com.amblessed;

import net.datafaker.Faker;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Test using AssertTrue")
    void getStudentsTestAssertTrue(){
        StudentService studentService = new StudentService();
        List<Student> listOfStudents = studentService.getStudents();
        boolean actualResult = listOfStudents.isEmpty();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Test using assertFalse")
    void getStudentsTestAssertFalse(){
        StudentService studentService = new StudentService();
        Faker faker = new Faker();
        Student student = new Student(1, faker.name().fullName());
        List<Student> listOfStudents = studentService.getStudents();
        studentService.addStudent(student);
        boolean actualResult = listOfStudents.isEmpty();
        assertFalse(actualResult, "List should not be empty");
    }

    @Test
    @DisplayName("Test using assertNull")
    void getStudentsByIdTestUsingAssertNull(){
        StudentService studentService = new StudentService();
        Faker faker = new Faker();
        Student student = new Student(1, faker.name().fullName());
        studentService.addStudent(student);
        Student actualResult = studentService.getStudentById(8);
        assertNull(actualResult);
    }

    @Test
    @DisplayName("Test using assertNotNull")
    void getStudentsByIdTestUsingAssertNotNull(){
        StudentService studentService = new StudentService();
        Faker faker = new Faker();
        Student student = new Student(1, faker.name().fullName());
        studentService.addStudent(student);
        Student actualResult = studentService.getStudentById(1);
        assertNotNull(actualResult);
    }

    @Test
    @DisplayName("Test using assertEquals \uD83D\uDE03")
    void getStudentsByIdTestUsingAssertEquals(){
        StudentService studentService = new StudentService();
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        Student student = new Student(1, fullName);
        studentService.addStudent(student);
        Student actualResult = studentService.getStudentById(1);
        assertEquals(student, actualResult);
        assertEquals(student.getId(), actualResult.getId());
        assertEquals(fullName, actualResult.getName());
    }

    @Test
    @DisplayName("Test using assertNotEquals")
    void getStudentsByIdTestUsingAssertNotEquals(){
        StudentService studentService = new StudentService();
        Faker faker = new Faker();
        Student studentOne = new Student(1, faker.name().fullName());
        studentService.addStudent(studentOne);

        Student studentTwo = new Student(2, faker.name().fullName());
        studentService.addStudent(studentTwo);

        Student actualResult = studentService.getStudentById(2);
        assertNotEquals(studentOne, actualResult);
        assertNotEquals(studentOne, studentTwo);
        assertNotEquals(studentOne.getId(), actualResult.getId());
        assertNotEquals(studentOne.getName(), actualResult.getName());
    }


    @Test
    @DisplayName("Test using assertArrayEquals")
    void getStudentsNamesByDepartmentTestUsingAssertArrayEquals(){
        StudentService studentService = new StudentService();
        Faker faker = new Faker();
        Student studentOne = new Student(1, faker.name().fullName(), "Computer Science");
        Student studentTwo = new Student(2, faker.name().fullName(), "Computer Science");
        Student studentThree = new Student(3, faker.name().fullName(), "Arts");
        Student studentFour = new Student(4, faker.name().fullName(), "Arts");
        studentService.addStudent(studentOne);
        studentService.addStudent(studentTwo);
        studentService.addStudent(studentThree);
        studentService.addStudent(studentFour);
        String[] actualResult = studentService.getStudentNamesByDepartment("Computer Science");
        String[] expectedResult = {studentOne.getName(), studentTwo.getName()};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test using assertIterableEquals")
    void getStudentsNamesListByDepartmentTestUsingAssertIterableEquals(){

        /* Elements of Iterable are equal
         * The order of elements should match
         * The number of elements should match
         * */

        StudentService studentService = new StudentService();
        Faker faker = new Faker();
        Student studentOne = new Student(1, faker.name().fullName(), "Computer Science");
        Student studentTwo = new Student(2, faker.name().fullName(), "Computer Science");
        Student studentThree = new Student(3, faker.name().fullName(), "Arts");
        Student studentFour = new Student(4, faker.name().fullName(), "Arts");
        studentService.addStudent(studentOne);
        studentService.addStudent(studentTwo);
        studentService.addStudent(studentThree);
        studentService.addStudent(studentFour);
        List<String> actualResult = studentService.getStudentNamesListByDepartment("Computer Science");
        List<String> expectedResult = List.of(studentOne.getName(), studentTwo.getName());
        assertIterableEquals(expectedResult, actualResult);

        List<Integer> actualResultInt = studentService.getStudentIdsListByDepartment("Computer Science");
        List<Integer> expectedResultInt = List.of(studentOne.getId(), studentTwo.getId());
        assertIterableEquals(expectedResultInt, actualResultInt);
    }

    @Test
    @DisplayName("Test using assertThrows")
    void getStudentByNameTestUsingAssertThrows(){
        /*
        * If the code throws an exception, the test will pass
        * If the code does not throw an exception, the test will fail
        * It follows an inheritance hierarchy; the assertion will pass if the expected type is the superclass(parent) of the actual exception type (subclass)
        * */

        StudentService  studentService = new StudentService();
        Faker faker = new Faker();
        Student studentOne = new Student(1, faker.name().fullName(), "Computer Science");
        studentService.addStudent(studentOne);
        assertThrows(StudentNotFoundException.class, () -> studentService.getStudentByName("JohnPeter DoeDoeDoe"));

        //It follows an inheritance hierarchy; the assertion will pass if the expected type is the superclass(parent) of the actual exception type (subclass)
        assertThrows(RuntimeException.class, () -> studentService.getStudentByName("JohnPeter DoeDoeDoe"));

    }

    @Test
    @DisplayName("Test using assertThrowsExactly")
    @Disabled("This test is disabled because it is not working as expected")
    void getStudentByNameTestUsingAssertThrowsExactly(){
        /*
         * If the code throws an exception, the test will pass
         * If the code does not throw an exception, the test will fail
         * It follows an inheritance hierarchy; the assertion will pass if the expected type is the superclass(parent) of the actual exception type (subclass)
         * */

        StudentService  studentService = new StudentService();
        Faker faker = new Faker();
        Student studentOne = new Student(1, faker.name().fullName(), "Computer Science");
        studentService.addStudent(studentOne);
        assertThrowsExactly(StudentNotFoundException.class, () -> studentService.getStudentByName("JohnPeter DoeDoeDoe"));

        //assertThrowsExactly does not follow an inheritance hierarchy;
        try{
            assertThrowsExactly(RuntimeException.class, () -> studentService.getStudentByName("JohnPeter DoeDoeDoe"));
        }
        catch (AssertionError e){
            System.out.println("AssertThrowsExactly failed because it does not follow the inheritance hierarchy");
        }

    }




}