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
    }

    private void A(Integer v) {
        v++; // equals to `v = v + 1`, which refer to another object whose
             // value is v + 1
             // It's impossible to modify the value of an Integer Object
             // after initializaiton.
    }

    @Test
    public void test_pass_by_ref() {
        Integer a = 3;
        A(a);
        assertEquals(Integer.valueOf(5), Integer.valueOf(5));
        assertEquals(Integer.valueOf(3), a);
    }

    @Test
    public void test_object_array_init() {
        Object[] arr = new Object[26];
        assertEquals(null, arr[0]);
        assertEquals(null, arr[25]);
    }
}
