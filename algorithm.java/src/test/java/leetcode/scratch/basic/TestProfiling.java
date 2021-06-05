package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.*;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class TestProfiling extends TestBase {

    @Test
    public void test_double_multiply() {
        int a = 65535;
        for (int i = 0; i < 1000; i++) {
            double_multiply(a);
        }
    }

    @Test
    public void test_double_add() {
        int a = 65535;
        for (int i = 0; i < 1000; i++) {
            double_add(a);
        }
    }

    // @Test
    // public void test_double_multiply() {
        // int a = 65535;
        // for (int i = 0; i < 1000; i++) {
            // double_multiply(a);
        // }
    // }

    private void double_add(int a) {
        int b = a + a;
    }

    private void double_multiply(int a) {
        int b = a * 2;
    }
}


/*
 *  Loop count      multiply(us)        add(us)
 *  1M              3270                3792
 *  100K            2019                2226
 *  10K             509                 749
 *  1K              96                  411
 *
 *  Conclusion: No idea:(
 */
