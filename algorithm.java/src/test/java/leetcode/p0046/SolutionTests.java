package leetcode.p0046;

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

    private static final String infile = IF_PREFIX + "p0046/1.dat";

    @Parameter(0)
    public int[] I0;

    @Parameter(1)
    public List<List<Integer>> E;

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
                params[1] = get2dList(sc, Integer.class);
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
        List<List<Integer>> ans = s.permute(I0);
        // printList2d(ans);
        for (int i = 0; i < E.size(); i++) {
            // assertArrayEquals(E.get(i).toArray(), ans.get(i).toArray());
        }
    }

    @Test
    public void test_2() {
        Solution s = new S2();
        List<List<Integer>> ans = s.permute(I0);
        // printList2d(ans);
        for (int i = 0; i < E.size(); i++) {
            // assertArrayEquals(E.get(i).toArray(), ans.get(i).toArray());
        }
    }

    @Test
    public void test_3() {
        Solution s = new S3();
        List<List<Integer>> ans = s.permute(I0);
        // printList2d(ans);
        for (int i = 0; i < E.size(); i++) {
            // assertArrayEquals(E.get(i).toArray(), ans.get(i).toArray());
        }
    }

    @Test
    public void test_3_1() {
        Solution s = new S3_1();
        List<List<Integer>> ans = s.permute(I0);
        // printList2d(ans);
        for (int i = 0; i < E.size(); i++) {
            // assertArrayEquals(E.get(i).toArray(), ans.get(i).toArray());
        }
    }
}
