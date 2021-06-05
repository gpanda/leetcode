package leetcode.p0036;

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

    private static final String infile = IF_PREFIX + "p0036/1.dat";

    @Parameter(0)
    public char[][] I;

    @Parameter(1)
    public boolean E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[2];

                List<List<Character>> list = get2dList(sc, Character.class);
                if (list == null) break;
                char[][] array = new char[list.size()][];
                int j = 0;
                for (List<Character> subl : list) {
                    char[] a = new char[subl.size()];
                    for (int i = 0; i < a.length; i++) {
                        a[i] = subl.get(i);
                    }
                    array[j++] = a;
                }
                params[0] = array;
                params[1] = getBoolean(sc);
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
//        System.out.println("[");
//        for (int i = 0; i < I.length; i++) {
//                System.out.print("[");
//            for (int j = 0; j < I[i].length; j++) {
//                System.out.print("\"" + I[i][j] + "\", ");
//            }
//            System.out.println("]");
//        }
//        System.out.println("]");
        Solution s = new S1();
        assertEquals(E, s.isValidSudoku(I));
    }

}

