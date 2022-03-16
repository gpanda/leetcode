package leetcode.libs;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.*;

import leetcode.TestBase;

public class RTreeTests2 extends TestBase {

    private static final String infile = IF_PREFIX + "libs/tree2.dat";

    @Parameter(0)
    public List<String> I0;

    @Parameter(1)
    public List<Integer> E0;

    @Parameter(2)
    public List<Integer> E1;

    @Parameter(3)
    public List<Integer> E2;

    @Parameter(4)
    public List<List<Integer>> E3;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[5];

                params[0] = getListOfString(sc);
                if (params[0] == null) break;

                params[1] = getListOfInteger(sc);
                if (params[1] == null) break;

                params[2] = getListOfInteger(sc);
                if (params[2] == null) break;

                params[3] = getListOfInteger(sc);
                if (params[3] == null) break;

                params[4] = get2dList(sc, Integer.class);
                if (params[4] == null) break;

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
    public void test_buildTree_level_by_level() {
        RTree.BinaryTreeNode<Integer> root =
            RTree.buildTreeLevelByLevel(I0, Integer.class);
        RTree.TreeNodeCollector<Integer> c = new RTree.TreeNodeCollector<>();

        RTree.inOrder(root, c);
        List<Integer> t = c.getCollection();
        assertArrayEquals(E0.toArray(new Integer[E0.size()]),
                t.toArray(new Integer[t.size()]));

        c.clear();

        RTree.preOrder(root, c);
        t = c.getCollection();
        assertArrayEquals(E1.toArray(new Integer[E1.size()]),
                t.toArray(new Integer[t.size()]));

        c.clear();

        RTree.levelOrder(root, c);
        t = c.getCollection();
        assertArrayEquals(E2.toArray(new Integer[E2.size()]),
                t.toArray(new Integer[t.size()]));

        c.clear();

        RTree.levelOrder_two_list(root, c);
        t = c.getCollection();
        assertArrayEquals(E2.toArray(new Integer[E2.size()]),
                t.toArray(new Integer[t.size()]));

        List<List<Integer>> levels = new ArrayList<>();
        RTree.getLevelsOfTree(levels, root, 0);
        assertEquals(E3.size(), levels.size());
        for (int i = 0; i < E3.size(); i++) {
            assertArrayEquals(
                    E3.get(i).toArray(
                        new Integer[E3.get(i).size()]
                        ),
                    levels.get(i).toArray(
                        new Integer[levels.get(i).size()]
                        )
            );
        }
    }

}
