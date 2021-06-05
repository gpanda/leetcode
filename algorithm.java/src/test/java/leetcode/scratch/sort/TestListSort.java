package leetcode.scratch.sort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import leetcode.TestBase;

/**
 * Created by gpanda on 3/31/17.
 */
@RunWith(value = JUnit4.class)
public class TestListSort extends TestBase {

    private class ListComparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> o1, List<Integer> o2) {
            Iterator<Integer> iter1 = o1.iterator();
            Iterator<Integer> iter2 = o2.iterator();
            Integer i = 0;
            while (iter1.hasNext() && iter2.hasNext()) {
                i = iter1.next() - iter2.next();
                if (i != 0) {
                    return i;
                }
            }
            if (iter1.hasNext()) {
                return 1;
            } else if (iter2.hasNext()) {
                return -1;
            }
            return 0;
        }
    }

    private class List3Comparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> o1, List<Integer> o2) {
            if (o1.get(0).equals(o2.get(0))) {
                if (o1.get(1).equals(o2.get(1))) {
                    return o1.get(2) - o2.get(2);
                } else {
                    return o1.get(1) - o2.get(1);
                }
            } else {
                return o1.get(0) - o2.get(0);
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> ll = new ArrayList<>(0);
        ll.add(Arrays.asList(1, 2, 3));
        ll.add(Arrays.asList(3, 2, 1));
        ll.add(Arrays.asList(2, 1, 3));
        ll.add(Arrays.asList(1, 2, -3));
        // Collections.sort(ll); // Cannot sort List of List
        Collections.sort(ll, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                Iterator<Integer> iter1 = o1.iterator();
                Iterator<Integer> iter2 = o2.iterator();
                Integer i = 0;
                while(iter1.hasNext() && iter2.hasNext()) {
                    i = iter1.next() - iter2.next();
                    if (i != 0) {
                        return i;
                    }
                }
                if (iter1.hasNext()) {
                    return 1;
                } else if (iter2.hasNext()) {
                    return -1;
                }
                return 0;
            }
        });
        assertArrayEquals(
            Arrays.asList(
                Arrays.asList(1, 2, -3),
                Arrays.asList(1, 2, 3),
                Arrays.asList(2, 1, 3),
                Arrays.asList(3, 2, 1)
            ).toArray(new ArrayList<List<Integer>>().toArray()),
            ll.toArray()
        );
    }

    @Test
    public void test_treeset_of_list_a1() {
        Set<List<Integer>> ts = new TreeSet<>(new ListComparator());
        ts.add(Arrays.asList(1, 2, 3));
        ts.add(Arrays.asList(3, 2, 1));
        ts.add(Arrays.asList(2, 1, 3));
        ts.add(Arrays.asList(1, 2, -3));
        assertArrayEquals(
            Arrays.asList(
                Arrays.asList(1, 2, -3),
                Arrays.asList(1, 2, 3),
                Arrays.asList(2, 1, 3),
                Arrays.asList(3, 2, 1)
            ).toArray(new ArrayList<List<Integer>>().toArray()),
            ts.toArray()
        );
    }

    @Test
    public void test_treeset_of_list_a2() {
        Set<List<Integer>> ts = new TreeSet<>(new List3Comparator());
        ts.add(Arrays.asList(1, 2, 3));
        ts.add(Arrays.asList(3, 2, 1));
        ts.add(Arrays.asList(2, 1, 3));
        ts.add(Arrays.asList(1, 2, -3));
        assertArrayEquals(
            Arrays.asList(
                Arrays.asList(1, 2, -3),
                Arrays.asList(1, 2, 3),
                Arrays.asList(2, 1, 3),
                Arrays.asList(3, 2, 1)
            ).toArray(new ArrayList<List<Integer>>().toArray()),
            ts.toArray()
        );
    }

    @Test
    public void test_treeset_of_list_b1() {
        Set<List<Integer>> ts = new TreeSet<>(new ListComparator());
        ts.add(Arrays.asList(-4, 0, 4));
        ts.add(Arrays.asList(-1001, 4, 997));
        ts.add(Arrays.asList(-2000, 0, 2000));
        ts.add(Arrays.asList(-1001, -999, 2000));
        assertArrayEquals(
            Arrays.asList(
                Arrays.asList(-2000, 0, 2000),
                Arrays.asList(-1001, -999, 2000),
                Arrays.asList(-1001, 4, 997),
                Arrays.asList(-4, 0, 4)
            ).toArray(new ArrayList<List<Integer>>().toArray()),
            ts.toArray()
        );
    }

    @Test
    public void test_treeset_of_list_b2() {
        Set<List<Integer>> ts = new TreeSet<>(new List3Comparator());
        ts.add(Arrays.asList(-4, 0, 4));
        ts.add(Arrays.asList(-1001, 4, 997));
        ts.add(Arrays.asList(-2000, 0, 2000));
        ts.add(Arrays.asList(-1001, -999, 2000));
        // System.out.println(ts);
        assertArrayEquals(
            Arrays.asList(
                Arrays.asList(-2000, 0, 2000),
                Arrays.asList(-1001, -999, 2000),
                Arrays.asList(-1001, 4, 997),
                Arrays.asList(-4, 0, 4)
            ).toArray(new ArrayList<List<Integer>>().toArray()),
            ts.toArray()
        );
    }

    @Test
    public void test_treeset_of_list_c1() {
        Set<List<Integer>> ts = new TreeSet<>(new ListComparator());
        List<Integer> list = null;
        list = Arrays.asList(1, 2, 3);
        Collections.sort(list);
        ts.add(list);
        list = Arrays.asList(3, 2, 1);
        Collections.sort(list);
        ts.add(list);
        list = Arrays.asList(2, 1, 3);
        Collections.sort(list);
        ts.add(list);
        list = Arrays.asList(1, 2, -3);
        Collections.sort(list);
        ts.add(list);
        assertArrayEquals(
            Arrays.asList(
                Arrays.asList(-3, 1, 2),
                Arrays.asList(1, 2, 3)
            ).toArray(new ArrayList<List<Integer>>().toArray()),
            ts.toArray()
        );
    }

    @Test
    public void test_treeset_of_list_c2() {
        Set<List<Integer>> ts = new TreeSet<>(new List3Comparator());
        List<Integer> list = null;
        list = Arrays.asList(1, 2, 3);
        Collections.sort(list);
        ts.add(list);
        list = Arrays.asList(3, 2, 1);
        Collections.sort(list);
        ts.add(list);
        list = Arrays.asList(2, 1, 3);
        Collections.sort(list);
        ts.add(list);
        list = Arrays.asList(1, 2, -3);
        Collections.sort(list);
        ts.add(list);
        assertArrayEquals(
            Arrays.asList(
                Arrays.asList(-3, 1, 2),
                Arrays.asList(1, 2, 3)
            ).toArray(new ArrayList<List<Integer>>().toArray()),
            ts.toArray()
        );
    }
}

