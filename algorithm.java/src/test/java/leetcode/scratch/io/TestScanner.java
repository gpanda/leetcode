package leetcode.scratch.io;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

/**
 * Created by gpanda on 4/24/17.
 */
@RunWith(value = JUnit4.class)
public class TestScanner extends TestBase {

    // public static final String delimiter = "\\[|, *|\\]|\n";

    @Test
    public void test_1() {
        Scanner sc = null;
        List<Integer> list = new ArrayList<>();
        try {
            sc = new Scanner(new File(IF_PREFIX + "scratch/io/1.dat"));
            sc.useDelimiter(DL);
            while (sc.hasNextInt()) {
                list.add(sc.nextInt());
            }
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }
        assertEquals(0, list.size());
        assertArrayEquals(new Integer[]{}, list.toArray());
    }

    @Test
    public void test_2() {
        Scanner sc = null;
        List<Integer> list = new ArrayList<>();
        try {
            sc = new Scanner(new File(IF_PREFIX + "scratch/io/2.dat"));
            sc.useDelimiter(DL); // \\R for all line breakers
            while (sc.hasNextInt()) {
                list.add(sc.nextInt());
            }
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }
        assertEquals(3, list.size());
        assertArrayEquals(new Integer[]{12345, -67890, 54321}, list.toArray());
    }

    @Test
    public void test_3() {
        Scanner sc = null;
        List<Integer> list = new ArrayList<>();
        try {
            sc = new Scanner(new File(IF_PREFIX + "scratch/io/3.dat"));
            sc.useDelimiter(DL);
            while (sc.hasNextInt()) {
                list.add(sc.nextInt());
            }
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }
        assertEquals(3, list.size());
        assertArrayEquals(new Integer[]{12345, -67890, 54321}, list.toArray());
    }

    @Test
    public void test_4() {
        Scanner sc = null;
        List<Integer> list = new ArrayList<>();
        try {
            sc = new Scanner(new File(IF_PREFIX + "scratch/io/4.dat"));
            sc.useDelimiter(DL);
            while (sc.hasNextInt()) {
                list.add(sc.nextInt());
            }
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }
        assertEquals(0, list.size());
        assertArrayEquals(new Integer[]{}, list.toArray());
    }

    @Test
    public void test_getSingle() {
        Scanner sc = null;
        Integer[][] E = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3},
            {4, 5, 6, 7, 8, 9},
            {2, 0, 1, 2, 0, 6},
        };
        List<Integer> list = new ArrayList<>();
        try {
            sc = new Scanner(new File(IF_PREFIX + "scratch/io/5.dat"));
            sc.useDelimiter(DL);
            Integer i = null;
            int c = 0;
            boolean flag = false;
            while (sc.hasNextLine()) {
                while ((i = getSingle(sc, Integer.class)) != null) {
                    list.add(i);
                    flag = true;
                }
                if (flag) {
                    flag = false;
                    assertArrayEquals(E[c++], list.toArray());
                    list.clear();
                }
                sc.nextLine();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }
    }

    @Test
    public void test_getList() {
        Scanner sc = null;
        Integer[][] E = {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {-1, -2, -3},
            {3, 2, 1},
            {1, 2, 3},
            {9, 8, 7},
            {2, 0, 1, 2, 0, 6},
        };
        try {
            List<Integer> list = null;
            sc = new Scanner(new File(IF_PREFIX + "scratch/io/5.dat"));
            int c = 0;
            for (String line = null;;) {
                line = nextLine(sc);
                if (line == null) break;
                list = getList(line, Integer.class);
                if (list != null) {
                    assertArrayEquals(E[c++], list.toArray());
                }
            }
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }
    }

    @Test
    public void test_getLists() {
        Integer[][][] E = {
            { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} },
            { {9, 8, 7}, {6, 5, 4}, {3, 2, 1} },
        };
        try {
            Scanner sc = new Scanner(new File(IF_PREFIX + "scratch/io/5.dat"));
            List<List<Integer>> lol = null;
            int c = 0;
            for (String line = null;;) {
                line = nextLine(sc);
                if (line == null) break;
                lol = get2dList(line, Integer.class);
                if (lol == null) continue;
                if (lol.size() > 0) {
                    Integer[][] array = lol.stream()
                        .map(o -> o.stream().toArray(Integer[]::new))
                        .toArray(Integer[][]::new);
                    assertEquals(E[c].length, array.length);
                    assertArrayEquals(E[c++], array);
                }
            }
            sc.close();
        } catch (FileNotFoundException fnfe) {
        }
    }

}

