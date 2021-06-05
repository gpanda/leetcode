package leetcode.p0084; // change

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;
import leetcode.libs.ListNode;

public class SolutionTests extends TestBase {

    private static final String infile = IF_PREFIX + "p0084/1.dat"; // change

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
            for (String line = null;;) {
                Object[] params = new Object[2]; // change params size

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
    public void test_1() {
        Solution s = new S1();
        assertEquals(E, s.largestRectangleArea(I0));
    }

    @Test
    public void test_2() {
        Solution s = new S2();
        assertEquals(E, s.largestRectangleArea(I0));
    }

    @Test
    public void test_ss1() {
        Solution s = new SS1();
        assertEquals(E, s.largestRectangleArea(I0));
    }

    @Test
    public void test_ss2() {
        Solution s = new SS2();
        assertEquals(E, s.largestRectangleArea(I0));
    }
}
