package leetcode.p0003;

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

    private static final String infile = IF_PREFIX + "p0003/1.dat";

    @Parameter(0)
    public String I;

    @Parameter(1)
    public Integer E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[2];

                line = nextLine(sc);
                if (line == null) break;
                params[0] = strip(line, " \"");
                if (params[0] == null) break;

                line = nextLine(sc);
                if (line == null) break;
                params[1] = getSingle(line, Integer.class);
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
    public void test_s1() {
        Solution s = new S1();
        assertEquals(E.intValue(), s.lengthOfLongestSubstring(I));
    }

}

