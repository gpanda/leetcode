package leetcode.p0146;

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

    private static final String infile = IF_PREFIX + "p0146/1.dat";

    @Parameter(0)
    public List<String> I0;

    @Parameter(1)
    public List<List<Integer>> I1;

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
                params[0] = getList(line, String.class);
                if (params[0] == null) break;

                line = nextLine(sc);
                if (line == null) break;
                params[1] = get2dList(line, Integer.class);
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
        LRUCache c = new S1(I1.get(0).get(0));
        for (int i = 1; i < I0.size(); i++) {
            String m = I0.get(i);
            List<Integer> args = I1.get(i);
            if ("put".equals(m)) {
                if (args.size() != 2) {
                    break; // exception
                }
                c.put(args.get(0), args.get(1));
            } else if ("get".equals(m)) {
                if (args.size() != 1) {
                    break; // exception
                }
                c.get(args.get(0));
            }
        }
        System.out.println(c);
    }

}

