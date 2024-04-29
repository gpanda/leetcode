package leetcode.libs;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

public class SearchUtilsTests_indexOfLt extends TestBase {

    private static final String infile = IF_PREFIX + "libs/iolt.dat";

    @Parameter(0)
    public List<Integer> I0;

    @Parameter(1)
    public int I1;

    @Parameter(2)
    public int E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[3];

                params[0] = getListOfInteger(sc);
                if (params[0] == null) break;

                params[1] = getInteger(sc);
                if (params[1] == null) break;

                params[2] = getInteger(sc);
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
    public void test_BinarySearchGE() {
        assertEquals(E, SearchUtils.indexOfLt(I0, I1));
    }
}

