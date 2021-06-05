package leetcode.p0040;

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

    private static final String infile = IF_PREFIX + "p0040/1.dat";

    @Parameter(0)
    public int[] I0;

    @Parameter(1)
    public int I1;

    @Parameter(2)
    public List<List<Integer>> E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[3]; // change params size

                params[0] = getListOfInt(sc);
                if (params[0] == null) break;
                params[1] = getInteger(sc);
                if (params[1] == null) break;
                params[2] = get2dList(sc, Integer.class);
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
    public void test_1() {
        Solution s = new S1();
        List<List<Integer>> results = s.combinationSum2(I0, I1);
        for (int i = 0; i < E.size(); i++) {
            assertArrayEquals(E.get(i).toArray(), results.get(i).toArray());
        }
    }

}

