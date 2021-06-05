package leetcode;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Ignore @RunWith(value = JUnit4.class)
public class TestBaseSimple
{

    private static final String VERBOSE = "verbose";

    protected static boolean isVerbose() {
        return "Y".equals(System.getProperty(VERBOSE));
    }

}
