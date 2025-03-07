package com.amblessed;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Mar-25
 */


public class SystemInfo {

    public String getOSName() {
        return System.getProperty("os.name");
    }

     public String getJavaVersion() {
        return System.getProperty("java.version");
    }

    /* public String getOSVersion() {
        return System.getProperty("os.version");
    }

    public String getOSArchitecture() {
        return System.getProperty("os.arch");
    }

    public String getJavaHome() {
        return System.getProperty("java.home");
    }

    public String getJavaVendor() {
        return System.getProperty("java.vendor");
    }*/
}
