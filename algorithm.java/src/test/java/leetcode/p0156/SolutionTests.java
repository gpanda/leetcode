package leetcode.p0156;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import leetcode.TestBase;
import leetcode.libs.RTree;

public class SolutionTests extends TestBase {

    private static final String infile = IF_PREFIX + "p0156/1.dat";

    @Parameter(0)
    public List<String> I0;

    @Parameter(1)
    public List<Integer> E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[2]; // change params size

                params[0] = getListOfString(sc);
                if (params[0] == null) break;

                params[1] = getListOfInteger(sc);
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
        RTree.BinaryTreeNode<Integer> root =
            RTree.buildTreeLevelByLevel(I0, Integer.class);
        RTree.BinaryTreeNode<Integer> reverse =
            s.upsideDownBinaryTree(root);
        RTree.TreeNodeCollector<Integer> c = new RTree.TreeNodeCollector<>();
        RTree.inOrderRecur(reverse, c);
        List<Integer> out = c.getCollection();
        assertArrayEquals(E.toArray(new Integer[E.size()]),
                out.toArray(new Integer[out.size()]));
    }

}
