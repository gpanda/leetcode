package leetcode.p0023;

import java.math.*;
import java.util.*;

public class S1 implements Solution {
    @Override
    public ListNode mergeKLists(ListNode[] lists) {
        int llen = lists.length;
        if (llen == 0) {
            return null;
        }
        RHeap heap = new RHeap(llen);
        for (ListNode p : lists) {
            heap.add(p);
        }
        if (heap.size() == 0) {
            return null;
        }
        ListNode h = null;
        try {
            h = heap.remove();
            heap.add(h.next);
            ListNode p = h;
            while (heap.size() > 0) {
                p.next = heap.remove();
                p = p.next;
                heap.add(p.next);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return h;
    }

    class RHeap {

        // min-heap

        private ListNode[] heap;

        int capacity = 0;
        int size = 0;

        public RHeap() {
            new RHeap(0);
        }

        public RHeap(int n) {
            if (n < 0) {
                return;
            }
            capacity = n;
            heap = new ListNode[capacity];
        }

        public int size() {
            return size;
        }

        public void add(ListNode a) {
            if (a == null) {
                return;
            }
            int child = size;
            int x = child % 2 == 0 ? 2 : 1;
            int parent = (child - x) / 2;
            while (parent >= 0 && heap[parent].val > a.val) {
                heap[child] = heap[parent];
                child = parent;
                x = child % 2 == 0 ? 2 : 1;
                parent = (child - x) / 2;
            }
            heap[child] = a;
            size++;
        }

        public ListNode remove() throws Exception {
            if (size <= 0) {
                throw new Exception("Empty, no item to remove!");
            }
            size--;
            ListNode ret = heap[0];
            if (size == 0) {
                return ret;
            }
            ListNode a = heap[size];
            int parent = 0;
            int lchild = 2 * parent + 1;
            int rchild = 2 * parent + 2;
            while (rchild < size) {
                if (a.val <= heap[lchild].val && a.val <= heap[rchild].val) {
                    break;
                }
                if (heap[lchild].val < heap[rchild].val) {
                    heap[parent] = heap[lchild];
                    parent = lchild;
                } else {
                    heap[parent] = heap[rchild];
                    parent = rchild;
                }
                lchild = 2 * parent + 1;
                rchild = 2 * parent + 2;
            }
            if (rchild == size) {
                if (heap[lchild].val < heap[rchild].val) {
                    heap[parent] = heap[lchild];
                    parent = lchild;
                }
            }
            heap[parent] = a;
            return ret;
        }
    }
}
