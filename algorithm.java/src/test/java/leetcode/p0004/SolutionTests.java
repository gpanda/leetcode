package leetcode.p0004;

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

    private static final String infile = IF_PREFIX + "p0005/1.dat";

    @Parameter(0)
    public int[] I0;

    @Parameter(1)
    public int[] I1;

    @Parameter(2)
    public Double E;

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
                List<Integer> l = getList(line, Integer.class);
                if (l == null) break;
                params[0] = l.stream().mapToInt(i->i).toArray();

                line = nextLine(sc);
                if (line == null) break;
                l = getList(line, Integer.class);
                if (l == null) break;
                params[1] = l.stream().mapToInt(i->i).toArray();

                line = nextLine(sc);
                if (line == null) break;
                params[2] = getSingle(line, Double.class);
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
    public void test_s1() {
        Solution s = new S1();
        assertEquals(E, Double.valueOf(s.findMedianSortedArrays(I0, I1)));
    }

}

