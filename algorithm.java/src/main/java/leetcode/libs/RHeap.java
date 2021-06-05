package leetcode.libs;

import java.util.*;

public class RHeap {

    // min-heap

    private int[] heap;

    double loadfactor = .75;
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
        heap = new int[capacity];
    }

    public int size() {
        return size;
    }

    public void add(int a) {
        int child = size;
        int x = child % 2 == 0 ? 2 : 1;
        int parent = (child - x) / 2;
        while (parent >= 0 && heap[parent] > a) {
            heap[child] = heap[parent];
            child = parent;
            x = child % 2 == 0 ? 2 : 1;
            parent = (child - x) / 2;
        }
        heap[child] = a;
        size++;
    }

    public int remove() throws Exception {
        if (size <= 0) {
            throw new Exception("Empty, no item to remove!");
        }
        size--;
        int ret = heap[0];
        if (size == 0) {
            return ret;
        }
        int a = heap[size];
        int parent = 0;
        int lchild = 2 * parent + 1;
        int rchild = 2 * parent + 2;
        while (rchild < size) {
            if (a <= heap[lchild] && a <= heap[rchild]) {
                break;
            }
            if (heap[lchild] < heap[rchild]) {
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
            if (heap[lchild] < heap[rchild]) {
                heap[parent] = heap[lchild];
                parent = lchild;
            }
        }
        heap[parent] = a;
        return ret;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(heap, size));
    }
}
