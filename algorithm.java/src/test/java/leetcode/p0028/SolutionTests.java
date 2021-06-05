package leetcode.p0028;

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

    private static final String infile = IF_PREFIX + "p0028/1.dat";

    @Parameter(0)
    public String I0;

    @Parameter(1)
    public String I1;

    @Parameter(2)
    public int E;

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
                line = line.trim();
                params[1] = trimQuotes(line);
                if (params[1] == null) break;

                line = nextLine(sc);
                if (line == null) break;
                params[2] = getSingle(line, Integer.class);
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
        assertEquals(E, s.strStr(I0, I1));
    }

}

