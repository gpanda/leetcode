package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import leetcode.TestBase;

/**
 * Created by gpanda on 5/18/17.
 */
@RunWith(value = JUnit4.class)
public class TestClass extends TestBase {

    @Test
    public void test() {
        Class t = Integer.class;
        assertFalse(t.isInstance(Integer.class));
        assertFalse(t.isInstance(1L));
        assertTrue(t.isInstance(1));
        assertEquals("java.lang.Integer", t.getName());
        assertEquals("Integer", t.getSimpleName());
        assertEquals("java.lang.Integer", t.getTypeName());
        assertEquals("java.lang.Integer", t.getCanonicalName());
    }
}
