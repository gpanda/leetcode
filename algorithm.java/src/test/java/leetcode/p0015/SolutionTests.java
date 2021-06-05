package leetcode.p0015;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;
import java.io.*;

import leetcode.TestBase;

/**
 * Unit test for all solutions
 */

@RunWith(value = Parameterized.class)
public class SolutionTests extends TestBase
{
    private static final String infile = IF_PREFIX + "p0015/2.dat";

    @Parameter(0)
    public int[] I;

    @Parameter(1)
    public List<List<Integer>> E;

    @Parameters
    public static Iterable<Object[]> data() {
        // Object[][] data = new Object[][] {
            // {
                // new int[]{3, 1, 2, -4},
                // Arrays.asList(Arrays.asList(-4, 1, 3))
            // },
            // {
                // new int[]{3, 1, 2, -4, 2},
                // Arrays.asList(
                    // Arrays.asList(-4, 1, 3), Arrays.asList(-4, 2, 2)
                // )
            // },
            // {
                // new int[]{-999, -1001, 4, -4, 2000, 0, -2000, 997},
                // Arrays.asList(
                    // Arrays.asList(-2000, 0, 2000),
                    // Arrays.asList(-1001, -999, 2000),
                    // Arrays.asList(-1001, 4, 997),
                    // Arrays.asList(-4, 0, 4)
                // )
            // },
            // {
                // new int[]{-1, 0, 1, 2, -1, -4},
                // Arrays.asList(
                    // Arrays.asList(-1, -1, 2),
                    // Arrays.asList(-1, 0, 1)
                // )
            // },
            // {
                // new int[]{3, -2, 1, 0},
                // Arrays.asList()
            // },
            // {
                // new int[]{100, 1, 0, 2, 0, -5, 0, -6, 0},
                // Arrays.asList(
                    // Arrays.asList(0, 0, 0)
                // )
            // },
            // {
                // new int[]{},
                // Arrays.asList()
            // },
        // };
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));

            for (String line = null;;) {
                Object[] params = new Object[2];

                line = nextLine(sc);
                if (line == null) break;
                List<Integer> list = getList(line, Integer.class);
                if (list == null) break;
                params[0] = list.stream().mapToInt(i -> i).toArray();

                line = nextLine(sc);
                if (line == null) break;
                params[1] = get2dList(line, Integer.class);
                if (params[1] == null) break;

                params_list.add(params);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } finally {
            if (sc != null) sc.close();
        }
        return params_list;
    }

    @Test
    public void test_s1() {
        Solution s = new S1();
        assertArrayEquals(E.toArray(), s.threeSum(I).toArray());
    }

    @Test
    public void test_s2() {
        Solution s = new S2();
        assertArrayEquals(E.toArray(), s.threeSum(I).toArray());
    }

    @Test
    public void test_s3() {
        Solution s = new S3();
        assertArrayEquals(E.toArray(), s.threeSum(I).toArray());
    }

    @Test
    public void test_s4() {
        Solution s = new S4();
        assertArrayEquals(E.toArray(), s.threeSum(I).toArray());
    }

    @Test
    public void test_s5() {
        Solution s = new S5();
        assertArrayEquals(E.toArray(), s.threeSum(I).toArray());
    }

    @Test
    public void test_s6() {
        Solution s = new S6();
        assertArrayEquals(E.toArray(), s.threeSum(I).toArray());
    }

    @Test
    public void test_s7() {
        Solution s = new S7();
        assertArrayEquals(E.toArray(), s.threeSum(I).toArray());
    }

    @Test
    public void test_s8() {
        Solution s = new S8();
        assertArrayEquals(E.toArray(), s.threeSum(I).toArray());
    }

    @Test
    public void test_s8_1() {
        Solution s = new S8_1();
        assertArrayEquals(E.toArray(), s.threeSum(I).toArray());
    }

    @Test
    public void test_s9() {
        Solution s = new S9();
        assertArrayEquals(E.toArray(), s.threeSum(I).toArray());
    }
}
