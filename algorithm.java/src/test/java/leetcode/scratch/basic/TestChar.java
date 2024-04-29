package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import leetcode.TestBase;

/**
 * Created by gpanda on 9/5/19.
 */
@RunWith(value = JUnit4.class)
public class TestChar extends TestBase {

    @Test
    public void test() {
        assertEquals(8, Byte.SIZE);
        assertEquals(2, Character.BYTES);

        char c = 0;
        char d = (char)-1;
        assertEquals((1 << Byte.SIZE * Character.BYTES) - 1, d);
        assertEquals(65535, d);
        assertEquals(0, c);
        // System.out.println("c=" + c + ",d=" + d);
    }
}
