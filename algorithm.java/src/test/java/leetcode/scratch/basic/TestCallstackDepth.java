package leetcode.scratch.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.*;

import leetcode.TestBase;

/**
    java -XX:+PrintFlagsFinal -version | grep ThreadStackSize
    intx CompilerThreadStackSize                  = 1024                                   {pd product} {default}
    intx ThreadStackSize                          = 1024                                   {pd product} {default}
    intx VMThreadStackSize                        = 1024                                   {pd product} {default}

    java -Xss4M -XX:+PrintFlagsFinal -version | grep ThreadStackSize
    intx CompilerThreadStackSize                  = 1024                                   {pd product} {default}
    intx ThreadStackSize                          = 4096                                   {pd product} {command line}
    intx VMThreadStackSize                        = 1024                                   {pd product} {default}

    mvn -DargLine="-Xss4M" -Dtest="scratch.basic.TestCallstackDepth" test

    4M makes test_6 pass 100%
 *
 */

@RunWith(value = JUnit4.class)
public class TestCallstackDepth extends TestBase {
    @Test
    public void test_1() {
        recur(5);
    }

    @Test
    public void test_2() {
        recur(1<<10);
    }

    @Test
    public void test_3() {
        recur(1<<13);
    }

    @Test
    public void test_4() {
        recur(1<<14);
    }

    @Test
    public void test_5() {
        recur(1<<15); // sometime: stack overflow, sometimes not
    }

    @Test
    public void test_6() {
        recur(1<<16); // stack overflow, need to increase Xss to 4MB
    }

    private void recur(int n)
    {
        if (n <= 0) return;
        recur(n-1);
    }
}

