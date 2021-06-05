package leetcode.p0023;

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

    private static final String infile = IF_PREFIX + "p0023/1.dat";

    @Parameter(0)
    public List<List<Integer>> I;

    @Parameter(1)
    public int[] E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<Object[]>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[2];

                line = nextLine(sc);
                if (line == null) break;
                params[0] = get2dList(line, Integer.class);
                if (params[0] == null) break;

                line = nextLine(sc);
                if (line == null) break;
                List<Integer> list = getList(line, Integer.class);
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
        Solution s = new S1();
        ListNode[] lns = new ListNode[I.size()];
        int i = 0;
        for (List<Integer> list : I) {
            lns[i] = new ListNode(list.get(0));
            ListNode p = lns[i];
            for (int j = 1; j < list.size(); j++) {
                p.next = new ListNode(list.get(j));
                p = p.next;
            }
            i++;
        }
        ListNode ln = s.mergeKLists(lns);
        List<Integer> ans = new ArrayList<>();
        for (ListNode p = ln; p != null; p = p.next) {
            ans.add(p.val);
        }

        assertArrayEquals(E, ans.stream().mapToInt(j->j).toArray());
    }

}

