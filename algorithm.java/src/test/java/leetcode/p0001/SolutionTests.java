package leetcode.p0001;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
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
    private static final String infile = IF_PREFIX + "p0001/1.dat";

    @Parameter(0)
    public int[] I;

    @Parameter(1)
    public int T;

    @Parameter(2)
    public int[] E;

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
                if (listI == null || listI.size() < 2) break;
                params[0] = listI.stream().mapToInt(i->i).toArray();

                line = nextLine(sc);
                if (line == null) break;
                Integer t = getSingle(line, Integer.class);
                if (isVerbose()) System.out.println(t);
                if (t == null) break;
                params[1] = t;

                line = nextLine(sc);
                if (line == null) break;
                List<Integer> listE = getList(line, Integer.class);
                if (isVerbose()) System.out.println(listE);
                if (listE == null || listE.size() < 2) break;
                params[2] = listE.stream().mapToInt(i->i).toArray();

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
        assertArrayEquals(E, s.twoSum(I, T));
    }

    @Test
    public void test_s2() {
        Solution s = new S2();
        assertArrayEquals(E, s.twoSum(I, T));
    }

    @Test
    public void test_s3() {
        Solution s = new S3();
        assertArrayEquals(E, s.twoSum(I, T));
    }

    @Test
    public void test_s4() {
        Solution s = new S4();
        assertArrayEquals(E, s.twoSum(I, T));
    }

}
