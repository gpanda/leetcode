package leetcode.scratch.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

import leetcode.TestBase;

/**
 * Created by gpanda on 3/31/17.
 */
@RunWith(value = JUnit4.class)
public class TestSetofSet extends TestBase {
    @Test
    public void test() {
        Set<Set<Integer>> s = new LinkedHashSet<>(0);
        s.add(new LinkedHashSet<>(Arrays.asList(1, 2, 3)));
        s.add(new LinkedHashSet<>(Arrays.asList(3, 2, 1)));
        s.add(new LinkedHashSet<>(Arrays.asList(2, 1, 3)));
        assertEquals(1, s.size());
    }
}
