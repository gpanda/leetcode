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

public class RTreeTests extends TestBase {

    private static final String infile = IF_PREFIX + "libs/tree.dat";
    @Parameter(0)
    public String ord1;

    @Parameter(1)
    public List<Integer> t1;

    @Parameter(2)
    public String ord2;

    @Parameter(3)
    public List<Integer> t2;

    @Parameter(4)
    public String ord3;

    @Parameter(5)
    public List<Integer> E;

    @Parameters
    public static Iterable<Object[]> data() {
        List<Object[]> params_list = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(infile));
            for (String line = null;;) {
                Object[] params = new Object[6];

                params[0] = getString(sc);
                if (params[0] == null) break;
                params[1] = getListOfInteger(sc);
                if (params[1] == null) break;

                params[2] = getString(sc);
                if (params[2] == null) break;
                params[3] = getListOfInteger(sc);
                if (params[3] == null) break;

                params[4] = getString(sc);
                if (params[4] == null) break;

                params[5] = getListOfInteger(sc);
                if (params[5] == null) break;

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
    public void test_buildtree_and_traverse_non_recur() {
        RTree.BinaryTreeNode<Integer> tree =
            RTree.<Integer>buildTree(ord1, t1, ord2, t2);
        List<Integer> out = null;
        try {
            Class<?> rtree_clazz = Class.forName("leetcode.libs.RTree");
            Method traverse = rtree_clazz.getDeclaredMethod(
                    ord3 + "Order",
                    RTree.BinaryTreeNode.class,
                    Consumer.class);
            RTree.TreeNodeCollector<Integer> c =
                new RTree.TreeNodeCollector<>();
            traverse.invoke(null, tree, c);
            out = c.getCollection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        assertArrayEquals(E.toArray(), out.toArray());
    }

    @Test
    public void test_buildtree_and_traverse_recur() {
        RTree.BinaryTreeNode<Integer> tree =
            RTree.<Integer>buildTree(ord1, t1, ord2, t2);
        List<Integer> out = null;
        try {
            Class<?> rtree_clazz = Class.forName("leetcode.libs.RTree");
            Method traverse = rtree_clazz.getDeclaredMethod(
                    ord3 + "OrderRecur",
                    RTree.BinaryTreeNode.class,
                    Consumer.class);
            RTree.TreeNodeCollector<Integer> c = new RTree.TreeNodeCollector<>();
            traverse.invoke(null, tree, c);
            out = c.getCollection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        assertArrayEquals(E.toArray(), out.toArray());
    }

    @Test
    public void test_buildtree_and_traverse_recur_fast() {
        RTree.BinaryTreeNode<Integer> tree =
            RTree.<Integer>buildTree_fast(ord1, t1, ord2, t2, Integer.MAX_VALUE);
        List<Integer> out = null;
        try {
            Class<?> rtree_clazz = Class.forName("leetcode.libs.RTree");
            Method traverse = rtree_clazz.getDeclaredMethod(
                    ord3 + "OrderRecur",
                    RTree.BinaryTreeNode.class,
                    Consumer.class);
            RTree.TreeNodeCollector<Integer> c = new RTree.TreeNodeCollector<>();
            traverse.invoke(null, tree, c);
            out = c.getCollection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        assertArrayEquals(E.toArray(), out.toArray());
    }
}
