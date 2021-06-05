package leetcode.p0083;

import java.util.*;
import java.util.stream.*;

import leetcode.libs.ListNode;

public class S1 implements Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode prev = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val != prev.val) {
                prev.next = next;
                prev = next;
            }
            next = next.next;
        }
        prev.next = next;
        return head;
    }
}
