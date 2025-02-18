# What is Junit
- Junit is a unit testing framework for Java
- It is used to test the individual units of code
- It is used to write and run repeatable tests
- Junit helps verify that individual units of code are working as expected
- Test method can be public, protected, or default


# @TestMethodOrder
- This annotation is used to control the order of the test methods in a class
- It is used at the class level to specify the order of the test methods within the class
- `MethodOrderer.Alphanumeric` is used to sort the test methods alphanumerically by their name
- `MethodOrderer.Random` is used to shuffle the order of the test methods
- `MethodOrderer.DisplayName` is used to sort the test methods by their display name
- `MethodOrderer.OrderAnnotation` is used to sort the test methods by `@Order` annotation

# @Order
- This annotation is used to control the order of the test methods in a class
- It is used at the method level to specify the order of the test methods within the class
- Used in conjunction with `@TestMethodOrder(MethodOrderer.OrderAnnotation.class)`