package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.*;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class TestString extends TestBase {
    @Test
    public void test_1() {
        String s = "Hello"
            + ", World! "
            + "I'm TestString. ";
        assertEquals("Hello, World! I'm TestString. ", s);

        String empty = "";
        String[] splits = empty.split("");
        assertEquals(1, splits.length);
        assertArrayEquals(new String[]{""}, splits);
        assertEquals("[]", Arrays.toString(splits));

        String[] splits2 = empty.split(" ");
        assertEquals(1, splits2.length);
        assertArrayEquals(new String[]{""}, splits2);
        assertEquals("[]", Arrays.toString(splits2));

        String[] splits3 = empty.split(",");
        assertEquals(1, splits3.length);
        assertArrayEquals(new String[]{""}, splits3);
        assertEquals("[]", Arrays.toString(splits3));

        String foo = ":bar:";
        String[] ss = foo.split(":");
        assertEquals(2, ss.length);                         // !!!
        assertArrayEquals(new String[]{"", "bar"}, ss);     // !!!
        assertEquals("[, bar]", Arrays.toString(ss));       // !!!
    }

    @Test
    public void test_2() {
        // String.valueOf(null));                           // NPE
        assertEquals("", new String());
        assertEquals("", new String(""));
    }

    @Test
    public void test_3() {
        // Test replace '"'
        // char to char replace
        String a = "\"put\"";
        a = a.replace('"', ' ').trim();
        // a = a.replace('\"', ' ').trim(); // also ok
        // a = a.replace('\"', '') // bad, '' is not any char
        assertEquals("put", a);
        // string to string replace
        String b = "\"put\"";
        b = b.replace("\"", "");
        assertEquals("put", b);
    }

    @Test
    public void test_substring() {
        String ty = "Jun Tae Yang";
        int len = ty.length();
        assertEquals("Jun", ty.substring(0, 3));
        assertEquals(ty, ty.substring(0, len));
        assertEquals("", ty.substring(len, len));
    }
}

