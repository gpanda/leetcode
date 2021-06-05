package leetcode.scratch.profiling;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

@RunWith(value=JUnit4.class)
public class TestArrayAccess extends TestBase {

    @Test
    public void test_function_call_1() {
        int[] array = new int[100];
        Arrays.fill(array, 5);
        int x;
        for (int i = 0; i < 100000; i++) {
            x = array[5];
        }
    }

    @Test
    public void test_function_call_2() {
        int[] array = new int[100];
        Arrays.fill(array, 5);
        int y = array[5];
        int x;
        for (int i = 0; i < 100000; i++) {
            x = y;
        }
    }

    @Test
    public void test_loop_1() {
        int[] array = new int[1000000];
        Arrays.fill(array, 5);
        int len = array.length;
        int x;
        for (int i = 0; i < len - 1; i++) x = array[i];
    }

    @Test
    public void test_loop_2() {
        int[] array = new int[1000000];
        Arrays.fill(array, 5);
        int len_1 = array.length - 1;
        int x;
        for (int i = 0; i < len_1; i++) x = array[i];
    }

    @Test
    public void test_loop_3() {
        int[] array = new int[1000000];
        Arrays.fill(array, 5);
        int len = array.length;
        int x;
        for (int i = 0; i < len - 1; i++) x = array[i];
    }

    @Test
    public void test_loop_a() {
        int[] array = new int[1000000];
        Arrays.fill(array, 5);
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int x = array[i];
        }
    }

    @Test
    public void test_loop_b() {
        int[] array = new int[1000000];
        Arrays.fill(array, 5);
        int x;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            x = array[i];
        }
    }
}

