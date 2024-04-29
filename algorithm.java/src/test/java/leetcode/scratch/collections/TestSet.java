package leetcode.scratch.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

import static org.junit.Assert.*;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class TestSet extends TestBase {
    @Test
    public void test() {
        Set<Character> s = new HashSet<>();
        s.add('a');
        assertTrue(s.contains('a'));
        assertFalse(s.contains('b'));
    }
}
