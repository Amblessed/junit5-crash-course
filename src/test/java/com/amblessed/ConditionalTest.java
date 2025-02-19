package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 19-Feb-25
 */


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//The Annotations here are valid if the test is executed at the class level.
public class ConditionalTest {

    @Test
    @Disabled("Don't run until JIRA #123 is resolved")
    @DisplayName("Basic Test")
    void basicTest(){
        System.out.println("Hello World!");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Test for Windows Operating System")
    void testForWindowsOnly(){
        System.out.println("Test for Windows Only!");
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(20, 30);
        assertEquals(50, actualResult);
    }

    @Test
    @EnabledOnOs(OS.MAC)
    @DisplayName("Test for Mac Operating System")
    void testForMacOnly(){
        System.out.println("Test for Mac Operating Systems Only!");
        Assertions.assertFalse(false);
    }


    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName("Test for Linux Operating System")
    void testForLinuxOnly(){
        System.out.println("Testing for Linux Operating Systems Only!");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    @DisplayName("Test for Linux and Windows Operating System")
    void testForWindowsAndLinuxOnly(){
        System.out.println("Testing for Linux and Windows Operating Systems!");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    @DisplayName("Test for Java version 17")
    void testForJava17(){
        System.out.println("Testing for Java version 17");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Test for Java version 17 and Windows Operating System")
    void testForJava17AndWindows(){
        System.out.println("Testing for Java version 17 and Windows Operating System!");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    @EnabledOnOs(OS.LINUX)
    @DisplayName("Test for Java version 17 and Linux Operating System")
    void testForJava17AndLinux(){
        System.out.println("Testing for Java version 17 and Linux Operating System!");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_21)
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Test for Java version 21 and Windows Operating System")
    void testForJava21AndWindows(){
        System.out.println("Testing for Java version 21 and Windows Operating System!");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
    @DisplayName("Test for Java version range 8 to 17")
    void testForJavaRange8to17(){
        System.out.println("Testing for Java version range 8 to 17");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_21)
    @DisplayName("Test for Java version range 17 to 21")
    void testForJavaRange17to21(){
        System.out.println("Testing for Java version range 17 to 21");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_21)
    @DisplayName("Test for Java version minimum 21")
    void testForJavaMinValue21(){
        System.out.println("Testing for Java version minimum 21");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11)
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Test for Java version minimum 11 and Windows Operating System")
    void testForJavaMinValue11AndWindows(){
        System.out.println("Testing for minimum Java version 11 and Windows Operating System!");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_21)
    @EnabledOnOs(OS.LINUX)
    @DisplayName("Test for Java version minimum 21 and Linux Operating System")
    void testForJavaMinValue21AndLinux(){
        System.out.println("Testing for minimum Java version 21 and Linux Operating System!");
        Assertions.assertTrue(true);
    }
}
