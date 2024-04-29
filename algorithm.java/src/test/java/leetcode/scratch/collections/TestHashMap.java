package leetcode.scratch.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import leetcode.TestBase;

/**
 * Created by gpanda on 3/31/17.
 */
@RunWith(value = JUnit4.class)
public class TestHashMap extends TestBase {

    @Test
    public void test() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2000, 0);
        map.put(4000, 1);
        map.put(-1, 2);
        map.put(8000, 3);
        map.put(4000, 3);
        assertEquals(map.get(4000), (Integer)3);
    }

    @Test
    public void test_update() {
        // Integer is immutable on the integer value if refers to. It's a
        // reference, its value is actually an address, any later assignment
        // won't change the integer value it refers to originally, but the
        // reference value to a new address which pointed to another integer.
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Integer a = map.get(1);
        a++; // no change on map
        Integer b = map.get(2);
        b *= -1; // no change on map
        Integer c = map.get(3);
        c %= c; // no change on map
        assertEquals((Integer)1, map.get(1));
        assertEquals((Integer)2, map.get(2));
        assertEquals((Integer)3, map.get(3));
    }

    @Test
    public void test_element_type() {
        // Map<int, char> map = new HashMap<>();     // unexpected type
    }

    @Test
    public void test_iterate_hashmap() {
        String s = "AACBCBAD";
        Map<Character, int[]> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            int[] arr = map.get(s.charAt(i));
            if (arr == null) {
                map.put(s.charAt(i), new int[]{1, 0});
            } else {
                arr[0]++;
            }
        }
        for (Map.Entry<Character, int[]> e : map.entrySet()) {
            /*
            System.out.println ("K:" + e.getKey() +
                                ",V:" + Arrays.toString(e.getValue()));
            */
            /*
                K:A,V:[3, 0]
                K:B,V:[2, 0]
                K:C,V:[2, 0]
                K:D,V:[1, 0]
             */
        }
    }

}

