package leetcode.p0005;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

public class SolutionTests extends TestBase {

    private static final String infile = IF_PREFIX + "p0005/1.dat";

    @Parameter(0)
    public String I;

    @Parameter(1)
    public List<String> E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[2];

                params[0] = getString(sc);
                if (params[0] == null) break;

                params[1] = getListOfString(sc);
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
        assertTrue(E.contains(s.longestPalindrome(I)));
    }

    @Test
    public void test_s2() {
        Solution s = new S2();
        assertTrue(E.contains(s.longestPalindrome(I)));
    }


    @Test
    public void test_s3() {
        Solution s = new S3();
        assertTrue(E.contains(s.longestPalindrome(I)));
    }

    @Test
    public void test_s0() {
        Solution s = new S0();
        assertTrue(E.contains(s.longestPalindrome(I)));
    }
}

