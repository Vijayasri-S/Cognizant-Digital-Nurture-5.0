package com.sample.Setting_Up_JUnit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class AAAExampleTest {

    int num1;
    int num2;
    int result;

    @Before
    public void setUp() {
        System.out.println("Before Test: Setting values");
        num1 = 10;
        num2 = 5;
    }

    @Test
    public void testAddition() {

        // ARRANGE
        System.out.println("Arrange: Numbers ready -> " + num1 + " and " + num2);

        // ACT
        result = num1 + num2;
        System.out.println("Act: Addition performed = " + result);

        // ASSERT
        assertEquals(15, result);
        System.out.println("Assert: Expected result matched");
    }

    @After
    public void tearDown() {
        System.out.println("After Test: Cleaning resources");
    }
}