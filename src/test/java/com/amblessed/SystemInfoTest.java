package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Mar-25
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemInfoTest {

    private SystemInfo systemInfo;


    @BeforeEach
    void setUp() {
        systemInfo = new SystemInfo();
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void getOSNameOnWindows() {
        String osName = systemInfo.getOSName();
        assertTrue(osName.contains("Windows"), "OS name should contain 'Windows'");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void getOSNameOnLinux() {
        String osName = systemInfo.getOSName();
        assertTrue(osName.contains("Linux"), "OS name should contain 'Linux'");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_21)
    void getJavaVersionOnJava21() {
        String javaVersion = systemInfo.getJavaVersion();
        assertTrue(javaVersion.startsWith("21"), "Java version should start with '11'");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    @EnabledOnOs(OS.MAC)
    void getOSNameOnMacWithJava17() {
        String osName = systemInfo.getOSName();
        String javaVersion = systemInfo.getJavaVersion();
        assertTrue(osName.contains("Mac"), "OS name should contain 'Mac'");
        assertTrue(javaVersion.startsWith("17"), "Java version should start with '17'");
    }


    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "development")
    void developmentEnvironment() {
        String environment = System.getenv("ENV");
        System.out.println(environment);
        //assertEquals("development", environment, "Environment variable 'ENVIRONMENT' should be 'development'");
    }
}
