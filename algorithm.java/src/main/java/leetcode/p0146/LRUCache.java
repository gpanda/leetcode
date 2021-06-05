package leetcode.p0146;

public abstract class LRUCache {

    protected int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public abstract int get(int key);
    public abstract void put(int key, int value);
    protected abstract boolean isFull();
}
