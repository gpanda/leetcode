package leetcode.scratch.profiling;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import leetcode.TestBase;

@RunWith(value = JUnit4.class)
public class TestPerformance extends TestBase
{
    @Test
    public void test() {
        int i = 0;
        while (i < 527764581) i++;
        assertEquals(527764581, i);
    }
}
