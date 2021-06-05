package leetcode.scratch.insert;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

public class TestInsert extends TestBase {

    private static final String infile = IF_PREFIX + "scratch/insert/1.dat";

    @Parameter(0)
    public int[] I0;

    @Parameter(1)
    public int I1;

    @Parameter(2)
    public int E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[3];

                line = nextLine(sc);
                if (line == null) break;
                List<Integer> list = getList(line, Integer.class);
                if (list == null) break;
                params[0] = list.stream().mapToInt(i->i).toArray();

                line = nextLine(sc);
                if (line == null) break;
                params[1] = getSingle(line, Integer.class);
                if (params[1] == null) break;

                line = nextLine(sc);
                if (line == null) break;
                params[2] = getSingle(line, Integer.class);
                if (params[2] == null) break;

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
    public void test_insert_1() {
        assertEquals(E, insert(I0, I1));
    }


    private int insert(int[] a, int x) {
        return insert(a, x, 0, a.length - 1);
    }

    private int insert(int[] a, int x, int l, int h) {
        if (a == null) return -1;
        if (l == 0 && h == -1) return 0;
        if (l < 0 || h < 0) return -1;
        if (l > h) return -1;
        while (l < h) {
            int m = (l + h) / 2;
            if (x == a[m]) {
                return m;
            } else if (x < a[m]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (l > h) {
            return l;
        } else { // l == h
            if (x <= a[l]) {
                return l;
            } else {
                return l + 1;
            }
        }
    }

}
