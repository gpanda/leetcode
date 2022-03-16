package leetcode.libs;

import java.util.*;

public class RDisjointSet<T>
{
    Map<T, Node<T>> nodemap;
    Map<Node<T>, RSet<T>> setmap;
    public RDisjointSet()
    {
        nodemap = new HashMap<>();
    }

    public void make_set(T v)
    {
        Node<T> n = new Node<>(v);
        nodemap.put(v, n);
        RSet<T> s = new RSet<>(n);
    }

    public RSet<T> union(RSet<T> S1, RSet<T> S2)
    {
        S1.union(S2);
        setmap.remove(S2.rep);
        return S1;
    }

    public RSet<T> findset(T v)
    {
        Node<T> n = nodemap.get(v);
        Node<T> save = n;
        while (n.rep != n) {
            n = n.rep;
        }
        save.rep = n;
        save.set = n.set;
        return n.set;
    }
}

class RSet<T>
{
    List<Node<T>> list;
    Node<T> rep;
    public RSet(Node<T> n)
    {
        list = new ArrayList<>();
        list.add(n);
        rep = n;
        n.set = this;
    }

    public RSet<T> union(RSet<T> s)
    {
        list.addAll(s.list);
        s.rep.rep = rep;
        return this;
    }
}

class Node<T>
{
    Node<T> rep;
    T val;
    RSet<T> set;

    public Node(T v)
    {
        val = v;
        rep = this;
    }
}


