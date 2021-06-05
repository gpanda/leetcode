package leetcode.p0006;

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

    private static final String infile = IF_PREFIX + "p0006/1.dat";

    @Parameter(0)
    public String I0;

    @Parameter(1)
    public int I1;

    @Parameter(2)
    public String E;

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
                line = line.trim();
                if (!line.matches("\".*\"")) break;
                line = line.substring(1, line.length() - 1);
                params[0] = line;

                line = nextLine(sc);
                if (line == null) break;
                params[1] = getSingle(line, Integer.class);
                if (params[1] == null) break;

                line = nextLine(sc);
                if (line == null) break;
                line = line.trim();
                if (!line.matches("\".*\"")) break;
                line = line.substring(1, line.length() - 1);
                params[2] = line;

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
        assertEquals(E, s.convert(I0, I1));
    }

    @Test
    public void test_s2() {
        Solution s = new S2();
        assertEquals(E, s.convert(I0, I1));
    }
}

