package leetcode.scratch.profiling;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

public class TestProfiling extends TestBase {

    private static final String infile = IF_PREFIX
        + "scratch/profiling/1.dat";

    @Parameter(0)
    public int[] I;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<Object[]>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[1];
                line = nextLine(sc);
                if (line == null) break;
                List<Integer> list = getList(line, Integer.class);
                if (list == null) continue;
                params[0] = list.stream().mapToInt(i->i).toArray();
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

    int abs(int n) {
        return n >= 0 ? n : -n;
    }

    @Test
    public void test_function_call_0() {
        for (int i : I) {
            int n = abs(i);
        }
    }

    @Test
    public void test_function_call_1() {
        for (int i : I) {
            int n = i >=0 ? i : -i;
        }
    }


}

