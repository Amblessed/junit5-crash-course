package com.amblessed.suite;



/*
 * @Project Name: junit5-crash-course
 * @Author: Okechukwu Bright Onwumere
 * @Created: 18-Feb-25
 */

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


// To use this annotation, we need to add the dependency: junit-platform-suite-engine
@Suite

// The classes must be public in order to be selected
//@SelectClasses({ClassATest.class, ClassBTest.class, ClassCTest.class})


// All Test would run here regardless if the classes are declared public or not
@SelectPackages({"com.amblessed"})
public class TestSuite {


}
