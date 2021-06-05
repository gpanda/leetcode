package leetcode.libs;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

public class RStringUtilsTests_strStr extends TestBase {

    private static final String infile =
        IF_PREFIX + "libs/stringutils_strstr.dat";

    @Parameter(0)
    public String I0;

    @Parameter(1)
    public String I1;

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

                line = nextLine(sc);
                if (line == null) break;
                line = line.trim();
                if (!line.matches("\".*\"")) break;
                line = line.substring(1, line.length() - 1);
                params[0] = line;

                line = nextLine(sc);
                if (line == null) break;
                line = line.trim();
                if (!line.matches("\".*\"")) break;
                line = line.substring(1, line.length() - 1);
                params[1] = line;

                line = nextLine(sc);
                if (line == null) break;
                params[2] = getSingle(line, Integer.class);;

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
        assertEquals(E, RStringUtils.strStr(I0, I1));
    }

}

