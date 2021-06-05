package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.*;
import java.util.stream.*;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class TestBitwise extends TestBase {
    @Test
    public void test_1() {
        // byte: signed 2's complement integer, -128 ~ 127
        // think of it using a clock circle
        // 0 ~ 127 mapped to 0 ~ 5 o'clock, -128 ~ -1 mapped to 6 ~ 11 o'clock
        // then 1 ~ 5 and -1 ~ -5 are symmetrical with respect to the line
        // passes 0 and 6 o'clock
        byte a = 127;
        a++;
        assertEquals(-128, a);
    }

    @Test
    public void test_2() {
        assertEquals(-64, -128 >> 1);
        assertEquals(1, 1 << 32); // cycled left shift
        assertEquals(4, 17 >> 2);
    }

    @Test
    public void test_3() {
        assertEquals("10001", Integer.toBinaryString(17));
        assertEquals("11101111", Integer.toBinaryString(-17).substring(24));
        assertEquals("10101110", Integer.toBinaryString(-82).substring(24));
    }

    @Test
    public void test_2complement() {
        assertEquals(0, 1^1);
        assertEquals(0, 0^0);
        assertEquals(1, 1^0);
        assertEquals(1, 0^1);
        assertEquals(-5, ~5 + 1); // ~a + 1 = -a
        assertEquals(-6, ~5);
        assertEquals(12, 17 + ~5 + 1);
        assertEquals(275, 535 + ~260 + 1);
    }

    @Test
    public void test_shift() {
        assertEquals(-408, -817 / 2);
        assertEquals(-409, -817 >> 1);
        assertEquals(408, 817 / 2);
        assertEquals(408, 817 >> 1);
        assertEquals(3, 7 / 2);
        assertEquals(3, 7 >> 1);
        assertEquals(-3, -7 / 2);
        assertEquals(-4, -7 >> 1);
        assertEquals(0, 1 / 2);
        assertEquals(0, 1 >> 1);
        assertEquals(0, -1 / 2);
        assertEquals(-1, -1 >> 1);
        assertEquals(2147483647, -1 >>> 1);
    }

    @Test
    public void test_binary_literal() {
        // in Java 7, 0b (0B) is introduced to express binary literal
        int a = 0b1111;
        int b = 0b1;
        assertEquals(15, a);
        assertEquals(1, b);
    }
}
