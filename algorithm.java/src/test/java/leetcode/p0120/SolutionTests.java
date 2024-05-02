package leetcode.p0120;

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

    private static final String infile = IF_PREFIX + "p0120/1.dat";

    @Parameter(0)
    public List<List<Integer>> I0;

    @Parameter(1)
    public int E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            while (true) { // break when reach the end of infile
                Object[] params = new Object[2];

                params[0] = get2dList(sc, Integer.class);
                if (params[0] == null) break;

                params[1] = getInteger(sc);
                if (params[1] == null) break;

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
    public void test_s1() {
        Solution s = new S1();
        assertEquals(E, s.minimumTotal(I0));
    }

    @Test
    public void test_s2() {
        Solution s = new S2();
        assertEquals(E, s.minimumTotal(I0));
    }

    @Test
    public void test_s3() {
        Solution s = new S3();
        assertEquals(E, s.minimumTotal(I0));
    }

    @Test
    public void test_s4() {
        Solution s = new S4();
        assertEquals(E, s.minimumTotal(I0));
    }
}
