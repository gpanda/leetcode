package leetcode.scratch.sort;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import leetcode.TestBase;

public class BitSetSortTests extends TestBase {

    private static final String infile = IF_PREFIX + "scratch/sort/bs.dat";

    @Parameter(0)
    public int I0;

    @Parameter(1)
    public List<List<Integer>> I1;

    @Parameter(2)
    public List<List<Integer>> E;

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
                params[0] = getSingle(line, Integer.class);
                if (params[0] == null) break;

                line = nextLine(sc);
                if (line == null) break;
                params[1] = get2dList(line, Integer.class);

                line = nextLine(sc);
                if (line == null) break;
                params[2] = get2dList(line, Integer.class);

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

    class ComparableList implements Comparable<ComparableList> {

        private BitSet weight = new BitSet();
        private List<Integer> list = null;

        public ComparableList(List<Integer> l) {
            list = l;
            for (Integer i : l) {
                weight.set(i);
            }
        }

        public BitSet getWeight() {
            return weight;
        }

        public List<Integer> getList() {
            return list;
        }

        public int compareTo(ComparableList that) {
            if (that == null) {
                return 1;
            }
            int alen = this.weight.length();
            int blen = that.getWeight().length();
            if (alen != blen) {
                return alen > blen ? 1 : -1;
            }
            BitSet xor = (BitSet) this.weight.clone();
            xor.xor(that.getWeight());
            int msb = xor.length() - 1;
            if (msb == -1) return 0;
            return this.weight.get(msb) ? 1 : -1;
        }
    }

    @Test
    public void test_1() {
        List<ComparableList> lcl = new ArrayList<>(I1.size());
        for (List<Integer> l : I1) {
            ComparableList cl = new ComparableList(l);
            lcl.add(cl);
        }
        Collections.sort(lcl);
        List<List<Integer>> lol = lcl.stream().map(ComparableList::getList)
            .collect(Collectors.toList());
        assertArrayEquals(E.toArray(), lol.toArray());
    }

}

