package leetcode.p0121;

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

    private static final String infile = IF_PREFIX + "p0121/1.dat";

    @Parameter(0)
    public int[] I0;

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

                params[0] = getListOfInt(sc);
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
        assertEquals(E, s.maxProfit(I0));
    }

    @Test
    public void test_s2() {
        Solution s = new S2();
        assertEquals(E, s.maxProfit(I0));
    }
}
