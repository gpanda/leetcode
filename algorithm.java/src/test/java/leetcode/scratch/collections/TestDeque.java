package leetcode.scratch.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.function.*;

import java.util.*;

import static org.junit.Assert.*;

import leetcode.TestBase;

/**
 * Created by gpanda on 11/18/19.
 * Last updated by gpanda on 04/17/24
 */
@RunWith(value = JUnit4.class)
public class TestDeque extends TestBase {

    @Test
    public void test_deque_iterator() {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            dq.add(i);
        }
        Iterator<Integer> iter = dq.iterator();
        int i = 0;
        while (iter.hasNext()) {
            assertEquals(new Integer(i++), iter.next());
        }
    }

    @Test
    public void test_deque_poll() {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            dq.add(i);
        }
        int i = 0;
        while (!dq.isEmpty()) {
            assertEquals(new Integer(i++), dq.poll());
        }
    }

    @Test
    public void test_deque_poll_and_iterator_1() {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            dq.add(i);
        }
        Iterator<Integer> iter = dq.iterator();
        int i = 0;
        while(!dq.isEmpty()) {
            // The sequence of the below 2 statements matters.
            // iter.next() before dq.poll() is OK, if dq.poll() goes first,
            // ConcurrentModificationException will be thrown.
            // See the root cause in the next test case.
            assertEquals(new Integer(i), iter.next());
            assertEquals(new Integer(i), dq.poll());
            i++;
        }
        assertEquals(5, i);
    }


    private void run(int i, Iterator<Integer> iter) {
        while (iter.hasNext()) {
            assertEquals(new Integer(i), iter.next());
            i++;
        }
    }

    @Test
    public void test_deque_poll_and_iterator_2() {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            dq.add(i);
        } // dq: [0, 1, 2, 3, 4]
        // create iter before the dq changes
        Iterator<Integer> iter = dq.iterator();
        assertEquals(new Integer(0), iter.next()); // now iter points to 1
        // remove the 3 heads of the dq
        int i = 0;
        while (i < 3) {
            assertEquals(new Integer(i), dq.poll());
            i++;
        } // i: 3
        final int fi = i;
        final Iterator<Integer> fiter = iter;
        assertThrows(ConcurrentModificationException.class, () ->
                run(fi, fiter));

        final Iterator<Integer> fiter2 = iter;
        assertThrows(ConcurrentModificationException.class, () -> {
            fiter2.next(); // root cause
                           // iter still points to 1, but 0, 1, 2 have been
                           // polled
        });
    }
}
