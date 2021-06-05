package leetcode.p0002;

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

    private static final String infile = IF_PREFIX + "p0002/1.dat";

    @Parameter(0)
    public List<Integer> I0;

    @Parameter(1)
    public List<Integer> I1;

    @Parameter(2)
    public List<Integer> E;

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
                params[0] = getList(line, Integer.class);
                if (params[0] == null) break;

                line = nextLine(sc);
                if (line == null) break;
                params[1] = getList(line, Integer.class);
                if (params[1] == null) break;


                line = nextLine(sc);
                if (line == null) break;
                params[2] = getList(line, Integer.class);
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

    private List<Integer> getIntegerList(ListNode n) {
        List<Integer> l = new ArrayList<>();
        while (n != null) {
            l.add(n.val);
            n = n.next;
        }
        return l;
    }

    @Test
    public void test_1() {
        Solution s = new S1();
        ListNode p = null;

        ListNode l1 = new ListNode(0);
        p = l1;
        for (Integer i : I0) {
            p.next = new ListNode(i);
            p = p.next;
        }
        l1 = l1.next;
        ListNode l2 = new ListNode(0);
        p = l2;
        for (Integer i : I1) {
            p.next = new ListNode(i);
            p = p.next;
        }
        l2 = l2.next;
        p = s.addTwoNumbers(l1, l2);
        assertArrayEquals(E.toArray(), getIntegerList(p).toArray());
    }

}

