package leetcode.libs;

import java.util.*;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int v) { val = v; }
    public static ListNode getLinkedList(List<Integer> l) {
        if (l == null || l.size() == 0) return null;
        ListNode head = new ListNode(l.get(0));
        ListNode cur = head;
        for (int i = 1; i < l.size(); i++) {
            ListNode next = new ListNode(l.get(i));
            cur.next = next;
            cur = next;
        }
        return head;
    }
    public static List<Integer> getList(ListNode ll) {
        List<Integer> l = new ArrayList<>();
        while (ll != null) {
            l.add(ll.val);
            ll = ll.next;
        }
        return l;
    }
}
