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

    class TYTY {
        String race;
        // public TYTY() {}
        public TYTY(String race) {
            if (race.equals("Terran") || race.equals("T")) {
                this.race = race;
            } else {
                // return null; // Compile Err: Void methods cannot return a value
                this.race = "Random";
            }
        }
    }

    @Test
    public void test_constructor_return_null() {
        // Constructor is not allowed to return null
        TYTY ty = new TYTY("T");
        assertEquals("T", ty.race);
        TYTY baby = new TYTY("Zerg");
        assertEquals("Random", baby.race);
    }
}
