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
public class TestLoop extends TestBase {
    @Test
    public void test_v_def_in_while() {
        int a = 0;

        while (a < 3) {
            int b = 0;
            if (a == 1) {
                b = 3;
            }
            if (a == 2) {
                b = 5;
            }
            System.out.println("a:" + a + ",b:" + b);
            a++;
        }
    }
}
