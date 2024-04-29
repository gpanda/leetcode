package leetcode.scratch.stream;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class StreamTests extends TestBase {

    private static final String infile = IF_PREFIX + "scratch/stream/1.dat";

    @Test
    public void test_1() {
        List<Integer> l = new ArrayList<>();
        l.add(Integer.valueOf(1));
        l.add(Integer.valueOf(3));
        l.add(Integer.valueOf(5));
        l.add(Integer.valueOf(7));
        l.add(Integer.valueOf(9));
        List<Integer> list = l.stream().map(e -> e * 2).collect(Collectors.toList());
        assertArrayEquals(new Integer[]{2, 6, 10, 14, 18}, list.toArray(new Integer[0]));
    }

    @Test
    public void test_2d_array_fill() {
        int[][] a = new int[5][3];
        Arrays.stream(a).forEach(r -> Arrays.fill(r, 9));
        for (int r = 0; r < a.length; r++) {
            assertArrayEquals(new int[]{9, 9, 9}, a[r]);
        }
    }

}

