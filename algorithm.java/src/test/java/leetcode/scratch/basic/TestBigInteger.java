package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.math.*;
import java.util.*;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class TestBigInteger extends TestBase {
    @Test
    public void test_1() {
        // byte[] space = new byte[] {
            // (byte)0x00, (byte)0x00, (byte)0x00, (byte)0xf0};
        byte[] space = new byte[4];
        BigInteger bi = new BigInteger(space);
        bi = bi.setBit(3);
        assertEquals(3, bi.getLowestSetBit());
        assertEquals(1, bi.bitCount());
        assertEquals(8, bi.intValue());
        bi = bi.clearBit(3);
        assertEquals(0, bi.intValue());
        bi = bi.setBit(1);
        bi = bi.setBit(3);
        bi = bi.setBit(5);
        bi = bi.setBit(7);
        assertEquals(4, bi.bitCount());
        assertEquals(8, bi.bitLength());
    }
}
