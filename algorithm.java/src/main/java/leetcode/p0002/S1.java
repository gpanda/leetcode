package leetcode.p0002;

import java.util.*;

public class S1 implements Solution {

    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = result;
        int s = 0;
        while (l1 != null && l2 != null) {
            p.next = new ListNode(0);
            p = p.next;
            s += l1.val + l2.val;
            if (s >= 10) {
                p.val = s - 10;
                s = 1;
            } else {
                p.val = s;
                s = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode r = null;
        if (l1 != null) {
            r = l1;
        } else if (l2 != null) {
            r = l2;
        }
        while (r != null) {
            p.next = new ListNode(0);
            p = p.next;
            s += p.val + r.val;
            if (s >= 10) {
                p.val = s - 10;
                s = 1;
            } else {
                p.val = s;
                s = 0;
            }
            r = r.next;
        }
        if (s > 0) {
            p.next = new ListNode(s);
        }
        return result.next;
    }

}
