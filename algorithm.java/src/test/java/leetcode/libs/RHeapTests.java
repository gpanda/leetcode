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

public class RHeapTests extends TestBase {

    private static final String infile = IF_PREFIX + "libs/heap.dat";

    @Parameter(0)
    public int[] I;

    @Parameter(1)
    public int[] E;

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
                List<Integer> list = getList(line, Integer.class);
                if (list == null) break;
                params[0] = list.stream().mapToInt(i->i).toArray();

                line = nextLine(sc);
                if (line == null) break;
                list = getList(line, Integer.class);
                if (list == null) break;
                params[1] = list.stream().mapToInt(i->i).toArray();

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
        RHeap heap = new RHeap(I.length);
        try{
            for (int i : I) {
                if (i < 0) {
                    heap.remove();
                } else {
                    heap.add(i);
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        assertEquals(Arrays.toString(E), heap.toString());
    }

}

