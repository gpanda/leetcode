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
public class TestReference extends TestBase {
    @Test
    public void test_1() {
        Object a = new Object();
        // System.out.println(a);
    }

    private void A(Integer v) {
        v++;
    }
    @Test
    public void test_pass_by_ref() {
        Integer a = 3;
        A(a);
        assertEquals(Integer.valueOf(5), Integer.valueOf(5));
        assertEquals(Integer.valueOf(3), a);
    }
}
