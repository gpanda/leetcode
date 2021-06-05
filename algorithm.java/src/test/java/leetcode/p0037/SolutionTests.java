package leetcode.p0037;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

public class SolutionTests extends TestBase {

    private static final String infile = IF_PREFIX + "p0037/1.dat";

    @Parameter(0)
    public char[][] I;

    @Parameter(1)
    public char[][] E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[2];

                List<List<Character>> list = get2dList(sc, Character.class);
                if (list == null) break;
                char[][] array = new char[list.size()][];
                int j = 0;
                for (List<Character> subl : list) {
                    char[] a = new char[subl.size()];
                    for (int i = 0; i < a.length; i++) {
                        a[i] = subl.get(i);
                    }
                    array[j++] = a;
                }
                params[0] = array;

                list = get2dList(sc, Character.class);
                if (list == null) break;
                array = new char[list.size()][];
                j = 0;
                for (List<Character> subl : list) {
                    char[] a = new char[subl.size()];
                    for (int i = 0; i < a.length; i++) {
                        a[i] = subl.get(i);
                    }
                    array[j++] = a;
                }
                params[1] = array;

                params_list.add(params);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return params_list;
    }

    @Test
    public void test_1() {
        Solution s = new S1();
        assertEquals(E.length, I.length);
        s.solveSudoku(I);
        for (int r = 0; r < E.length; r++) {
            assertArrayEquals(E[r], I[r]);
        }
    }

    @Test
    public void test_2() {
        Solution s = new S2();
        assertEquals(E.length, I.length);
        s.solveSudoku(I);
        for (int r = 0; r < E.length; r++) {
            assertArrayEquals(E[r], I[r]);
        }
    }
}

