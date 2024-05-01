package leetcode.templates;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;
import java.util.*;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class SolutionTests2 extends TestBase {

    @Test
    public void test_1() {
        Solution s = new S1();
        s.func_template2();
    }

    @Test
    public void test_strip() {
        String set0 = "\"ac";
        String set1 = "\"abc\"";
        String s0 = "\"abc\"";
        assertEquals("b", strip(s0, set0));
        assertEquals("", strip(s0, set1));

        String set3 = null;
        String set4 = "";
        String set5 = "a";
        String s1 = "   \"abc   ";
        assertEquals("\"abc", strip(s1, set3));
        assertEquals("\"abc", strip(s1, set4));
        assertEquals("   \"abc   ", strip(s1, set5));
        assertEquals(null, strip(null, set5));
        assertEquals(null, strip(null, set5));
    }

}

