package leetcode.libs;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.*;

import leetcode.TestBase;

public class RDisjointSetTests extends TestBase {

    private static final String infile = IF_PREFIX + "libs/disjointset.dat";
    @Parameter(0)
    public int n;

    @Parameter(1)
    public int[][] edges;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[2];

                params[0] = getInteger(sc);
                if (params[0] == null) break;
                List<List<Integer>> tmp = get2dList(sc, Integer.class);
                if (tmp == null || tmp.size() == 0) break;
                Integer[][] tmp2 = nestedListTo2dArray(tmp, Integer.class);
                params[1] = new int[tmp2.length][tmp2[0].length];
                unboxing2dArray(tmp2, params[1], Integer.class);
                System.out.println(((int[][])params[1]).length);
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
    public void test_disjointset_3_operations() {
    }
}
