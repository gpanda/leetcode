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

public class RBitwiseTests extends TestBase {

    private static final String infile = IF_PREFIX + "libs/bitwise.dat";

    @Parameter(0)
    public int I;

    @Parameter(1)
    public byte[] E;

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
                params[0] = getSingle(line, Integer.class);
                if (params[0] == null) break;

                line = nextLine(sc);
                if (line == null) break;
                List<Byte> list = getList(line, Byte.class);
                if (list == null) break;
                byte[] byts = new byte[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    byts[i] = list.get(i);
                }
                params[1] = byts;

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
        assertArrayEquals(E, RBitwise.toBytes(I));
    }

}

