package leetcode.p0016;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

/**
 * Unit test for all solutions
 */
public class SolutionTests extends TestBase
{
    private static final String infile = IF_PREFIX + "p0016/1.dat";

    @Parameter(0)
    public int[] I;

    @Parameter(1)
    public int T;

    @Parameter(2)
    public int E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            // sc.useDelimiter(LIST_DELIMITER);
            for (String line = null;;) {
                Object[] params = new Object[3];

                line = nextLine(sc);
                if (line == null) break;
                List<Integer> listI = getList(line, Integer.class);
                if (isVerbose()) System.out.println(listI);
                if (listI == null || listI.size() < 3) break;
                params[0] = listI.stream().mapToInt(i->i).toArray();

                line = nextLine(sc);
                if (line == null) break;
                Integer T = getSingle(line, Integer.class);
                if (isVerbose()) System.out.println(T);
                if (T == null) break;
                params[1] = T;

                line = nextLine(sc);
                if (line == null) break;
                Integer E = getSingle(line, Integer.class);
                if (isVerbose()) System.out.println(E);
                if (E == null) break;
                params[2] = E;

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
        assertEquals(E, s.threeSumClosest(I, T));
    }

    @Test
    public void test_s2() {
        Solution s = new S2();
        assertEquals(E, s.threeSumClosest(I, T));
    }

    @Test
    public void test_s3() {
        Solution s = new S3();
        assertEquals(E, s.threeSumClosest(I, T));
    }

    @Test
    public void test_s4() {
        Solution s = new S4();
        assertEquals(E, s.threeSumClosest(I, T));
    }

    @Test
    public void test_s5() {
        Solution s = new S5();
        assertEquals(E, s.threeSumClosest(I, T));
    }

    @Test
    public void test_s6() {
        Solution s = new S6();
        assertEquals(E, s.threeSumClosest(I, T));
    }

    @Test
    public void test_s7() {
        Solution s = new S7();
        assertEquals(E, s.threeSumClosest(I, T));
    }

    @Test
    public void test_s7_1() {
        Solution s = new S7_1();
        assertEquals(E, s.threeSumClosest(I, T));
    }

    @Test
    public void test_s01() {
        Solution s = new S01();
        assertEquals(E, s.threeSumClosest(I, T));
    }
}

