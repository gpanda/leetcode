package leetcode.p0030;

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

    private static final String infile = IF_PREFIX + "p0030/1.dat";

    @Parameter(0)
    public String I0;

    @Parameter(1)
    public String[] I1;

    @Parameter(2)
    public int[] E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<Object[]>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[3];

                line = nextLine(sc);
                if (line == null) break;
                line = line.trim();
                params[0] = trimQuotes(line);
                if (params[0] == null) break;

                line = nextLine(sc);
                if (line == null) break;
                List<String> l1 = getList(line, String.class);
                if (l1 == null) break;
                params[1] = l1.toArray(new String[0]);

                line = nextLine(sc);
                if (line == null) break;
                List<Integer> l2 = getList(line, Integer.class);
                if (l2 == null) break;
                params[2] = l2.stream().mapToInt(i->i).toArray();

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
        List<Integer> results = s.findSubstring(I0, I1);
        assertArrayEquals(E, results.stream().mapToInt(i->i).toArray());
    }

}

