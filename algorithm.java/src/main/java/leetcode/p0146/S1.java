package leetcode.p0146;

import java.util.*;

public class S1 extends LRUCache {

    private int head;
    private int tail;
    private int size;
    private int[][] cache;
    private Map<Integer, Integer> hash;
    public S1(int capacity) {
        super(capacity);
        head = -1;
        tail = 0;
        size = 0;
        cache = new int[capacity][4]; // 0-3: key, value, prev, next
        hash = new HashMap<>(capacity);
    }

    @Override
    public int get(int key) {
        // System.out.println("get(" + key + ")");
        Integer find = hash.get(key);
        // key not exists
        if (find == null) {
            return -1;
        }
        // key exists
        // recently accessed, make it to the head if it is not
        if (find != head) {
            if (find == tail) {
                tail = cache[find][3];
                cache[tail][2] = -1; // not a must
            } else {
                cache[cache[find][2]][3] = cache[find][3];
                cache[cache[find][3]][2] = cache[find][2];
            }
            cache[head][3] = find;
            cache[find][2] = head;
            cache[find][3] = -1; // not a must
            head = find;
        }

        return cache[find][1];
    }

    @Override
    public void put(int key, int value) {
        // System.out.println("put(" + key + ", " + value + ")");
        Integer find = hash.get(key);
        if (find != null) { // key exists, update
            if (cache[find][1] != value) {
                cache[find][1] = value;
            }
            get(key);
        } else { // key not exists, insert as the head
            if (! isFull()) {
                cache[size][0] = key;
                cache[size][1] = value;
                cache[size][2] = head;
                if (head >= 0) {
                    cache[head][3] = size;
                }
                head = size;
                size++;
            } else { // full
                // remove the tail's k,v map entry from hash
                hash.remove(cache[tail][0]);

                cache[tail][0] = key;
                cache[tail][1] = value;
                cache[tail][2] = head;
                cache[head][3] = tail;
                head = tail;
                tail = cache[tail][3];
                cache[head][3] = -1;        // not a must
                cache[tail][2] = -1;        // not a must
            }
            // add k, head to hash
            hash.put(key, head);
        }
    }

    @Override
    protected boolean isFull() {
        return size >= capacity;
    }

    @Override
    public String toString() {
        return "HashMap:||" + hash + "||.\n" +
               "Cache:||" + Arrays.deepToString(cache) + "||.\n";
    }

}
