package leetcode.p0018;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

public class SolutionTests2 extends TestBase {

    private static final String infile = IF_PREFIX + "p0018/2.dat";

    @Parameter(0)
    public int[] I0;

    @Parameter(1)
    public int I1;

    @Parameter(2)
    public List<List<Integer>> E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<Object[]>();
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
                params[2] = get2dList(line, Integer.class);
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
    public void test_2() {
        Solution s = new S2();
        assertArrayEquals(E.toArray(), s.fourSum(I0, I1).toArray());
    }

    @Test
    public void test_3() {
        Solution s = new S3();
        assertArrayEquals(E.toArray(), s.fourSum(I0, I1).toArray());
    }

    @Test
    public void test_4() {
        Solution s = new S4();
        assertArrayEquals(E.toArray(), s.fourSum(I0, I1).toArray());
    }

    @Test
    public void test_5() {
        Solution s = new S5();
        assertArrayEquals(E.toArray(), s.fourSum(I0, I1).toArray());
    }

    @Test
    public void test_6() {
        Solution s = new S6();
        assertArrayEquals(E.toArray(), s.fourSum(I0, I1).toArray());
    }

    @Test
    public void test_7() {
        Solution s = new S7();
        assertArrayEquals(E.toArray(), s.fourSum(I0, I1).toArray());
    }

    @Test
    public void test_8() {
        Solution s = new S8();
        assertArrayEquals(E.toArray(), s.fourSum(I0, I1).toArray());
    }
}

