package com.sample.Setting_Up_JUnit;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        assertEquals(20, 10 + 10);     // expected, actual

        assertTrue(8 > 3);             // true condition

        assertFalse(2 > 7);            // false condition

        String name = null;
        assertNull(name);              // should be null

        String course = "JUnit";
        assertNotNull(course);         // should not be null
        
        //fail test for understanding
        assertEquals(10, 3+6);
    }
}