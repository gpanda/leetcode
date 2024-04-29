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
public class TestLimits extends TestBase {
    @Test
    public void test_big_array() {
        int[] a = new int[700531452];
        assertEquals(700531452, a.length);
    }
}
