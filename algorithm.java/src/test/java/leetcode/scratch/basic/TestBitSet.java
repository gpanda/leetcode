package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.*;
import java.math.*;
import java.util.*;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class TestBitSet extends TestBase {

    private static final String infile = IF_PREFIX + "scratch/basic/bs.dat";

    int compare(BitSet bs1, BitSet bs2) {
        if (bs1 == null || bs2 == null) {
            return -2;
        }
        BitSet xor = (BitSet) bs1.clone();
        xor.xor(bs2);
        int msb = xor.length() - 1;
        if (msb == -1) {
            return 0;
        }
        return bs1.get(msb) ? 1 : -1;
    }

    @Test
    public void test_1() {
        BitSet bs1 = new BitSet(8);
        bs1.set(1);
        bs1.set(3);
        bs1.set(5);
        bs1.set(7);
        assertEquals("{1, 3, 5, 7}", bs1.toString());
        assertEquals(8, bs1.length());
        BitSet bs2 = new BitSet(8);
        bs2.set(1);
        bs2.set(3);
        bs2.set(5);
        bs2.set(7);
        assertEquals(0, compare(bs1, bs2));
        BitSet bs3 = new BitSet(8);
        bs3.set(0);
        bs3.set(3);
        bs3.set(5);
        bs3.set(7);
        assertEquals(1, compare(bs1, bs3));
        assertEquals(8, bs3.length());
        BitSet bs4 = new BitSet(8);
        bs4.set(0);
        bs4.set(3);
        bs4.set(6);
        bs4.set(7);
        assertEquals(-1, compare(bs1, bs4));
        BitSet bs5 = new BitSet();
        BitSet bs6 = new BitSet();
        assertEquals(0, compare(bs5, bs6));
        assertEquals(-2, compare(null, null));
        assertEquals(-2, compare(new BitSet(), null));
        BitSet bs7 = new BitSet(8);
        bs7.set(6);
        bs7.set(7);
        assertEquals(8, bs7.length());
    }

    class MyBitSetComparator implements Comparator<BitSet> {
        public int compare(BitSet a, BitSet b) {
            if (a == null || b == null) {
                return -2;
            }
            int alen = a.length();
            int blen = b.length();
            if (alen != blen) {
                return blen > alen ? 1 : -1;
            }
            BitSet xor = (BitSet) a.clone();
            xor.xor(b);
            int msb = xor.length() - 1;
            if (msb == -1) return 0;
            return a.get(msb) ? 1 : -1;
        }
    }


    class MyBitSetComparator1 implements Comparator<BitSet> {
        public int compare(BitSet a, BitSet b) {
            if (a == null || b == null) {
                return -2;
            }
            BitSet xor = (BitSet) a.clone();
            xor.xor(b);
            int msb = xor.length() - 1;
            if (msb == -1) return 0;
            return a.get(msb) ? 1 : -1;
        }
    }
}
