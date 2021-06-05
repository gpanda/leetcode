package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.*;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class TestMultiline extends TestBase {
    @Test
    public void test_multiline1() {
        String s = "Hello"
            + ", World! "
            + "I'm TestString. ";
        assertEquals("Hello, World! I'm TestString. ", s);
    }

    @Test
    public void test_multiline2() {
        assertEquals(true, isDigit('0'));
        assertEquals(true, isDigit('1'));
        assertEquals(true, isDigit('2'));
        assertEquals(true, isDigit('3'));
        assertEquals(true, isDigit('4'));
        assertEquals(true, isDigit('5'));
        assertEquals(true, isDigit('6'));
        assertEquals(true, isDigit('7'));
        assertEquals(true, isDigit('8'));
        assertEquals(true, isDigit('9'));
        assertEquals(false, isDigit('a'));
    }

    boolean isDigit(char c) {
        return
            c == '0' ||
            c == '1' ||
            c == '2' ||
            c == '3' ||
            c == '4' ||
            c == '5' ||
            c == '6'
            || c == '7'
            || c == '8' ||
            c == '9';
    }
}

