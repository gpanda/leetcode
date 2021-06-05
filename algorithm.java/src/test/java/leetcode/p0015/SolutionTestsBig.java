package leetcode.p0015;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

/**
 * Unit test for all solutions
 */
public class SolutionTestsBig extends TestBase
{
    private static final String infile = IF_PREFIX + "p0015/1.dat";

    @Parameter(0)
    public int[] I;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            // sc.useDelimiter(LIST_DELIMITER);
            for (String line = null;;) {
                Object[] params = new Object[1];

                line = nextLine(sc);
                if (line == null) break;
                List<Integer> list = getList(line, Integer.class);
                if (list == null || list.size() < 3) break;
                params[0] = list.stream().mapToInt(i->i).toArray();

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
    public void test_s1_big_case() {
        Solution s = new S1();
        s.threeSum(I);
    }

    @Test
    public void test_s2_big_case() {
        Solution s = new S2();
        s.threeSum(I);
    }

    @Test
    public void test_s3_big_case() {
        Solution s = new S3();
        s.threeSum(I);
    }

    @Test
    public void test_s4_big_case() {
        Solution s = new S4();
        s.threeSum(I);
    }

    @Test
    public void test_s5_big_case() {
        Solution s = new S5();
        s.threeSum(I);
    }

    @Test
    public void test_s6_big_case() {
        Solution s = new S6();
        s.threeSum(I);
    }

    @Test
    public void test_s7_big_case() {
        Solution s = new S7();
        s.threeSum(I);
    }

    @Test
    public void test_s8_big_case() {
        Solution s = new S8();
        s.threeSum(I);
    }

    @Test
    public void test_s8_1_big_case() {
        Solution s = new S8_1();
        s.threeSum(I);
    }

    @Test
    public void test_s9_big_case() {
        Solution s = new S9();
        s.threeSum(I);
    }
}

