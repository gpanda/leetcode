package leetcode.libs;

import java.util.*;
import java.util.function.*;



public class RTree
{
    public static class BinaryTreeNode<T>
    {
        public T val;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;
        public BinaryTreeNode() {}
        public BinaryTreeNode(T v) { this.val = v; }
        public BinaryTreeNode(T v, BinaryTreeNode<T> l, BinaryTreeNode<T> r)
        {
            this.val = v;
            this.left = l;
            this.right = r;
        }
    }

    public static class TreeNodeCollector<T>
            implements Consumer<BinaryTreeNode<T>>
    {
        private List<T> l = null;
        public TreeNodeCollector()
        {
            l = new ArrayList<T>();
        }

        public List<T> getCollection()
        {
            return l;
        }

        public void clear()
        {
            l.clear();
        }

        @Override
        public void accept(BinaryTreeNode<T> root)
        {
            l.add(root.val);
        }
    }

    public static <T> void inOrder(
            BinaryTreeNode<T> root,
            Consumer<BinaryTreeNode<T>> c)
    {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (true) {
            if (root == null) {
                if (stack.empty()) break;
                root = stack.pop();
                c.accept(root);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
    }

    public static <T> void postOrder(
            BinaryTreeNode<T> root,
            Consumer<BinaryTreeNode<T>> c)
    {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (true) {
            if (root == null) {
                if (stack.empty()) break;
                root = stack.pop();
                if (!stack.empty() && root == stack.peek()) {
                    root = root.right;
                } else {
                    c.accept(root);
                    root = null;
                }
            } else {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
        }
    }

    public static <T> void preOrder(
            BinaryTreeNode<T> root,
            Consumer<BinaryTreeNode<T>> c)
    {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (true) {
            if (root == null) {
                if (stack.empty()) break;
                root = stack.pop();
                root = root.right;
            } else {
                c.accept(root);
                stack.push(root);
                root = root.left;
            }
        }
    }

    public static <T> void inOrderRecur(
            BinaryTreeNode<T> root,
            Consumer<BinaryTreeNode<T>> c)
    {
        if (root == null) return;
        inOrderRecur(root.left, c);
        c.accept(root);
        inOrderRecur(root.right, c);
    }

    public static <T> void postOrderRecur(
            BinaryTreeNode<T> root,
            Consumer<BinaryTreeNode<T>> c)
    {
        if (root == null) return;
        postOrderRecur(root.left, c);
        postOrderRecur(root.right, c);
        c.accept(root);
    }

    public static <T> void preOrderRecur(
            BinaryTreeNode<T> root,
            Consumer<BinaryTreeNode<T>> c)
    {
        if (root == null) return;
        c.accept(root);
        preOrderRecur(root.left, c);
        preOrderRecur(root.right, c);
    }

    public static <T> void levelOrder(
            BinaryTreeNode<T> root,
            Consumer<BinaryTreeNode<T>> c)
    {
        if (root == null) return;
        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<T> n = queue.poll();
                c.accept(n);
                if (n.left != null) queue.offer(n.left);  // add or offer?
                if (n.right != null) queue.offer(n.right); // add may fast?
            }
        }
    }

    public static <T> void levelOrder_two_list(
            BinaryTreeNode<T> root,
            Consumer<BinaryTreeNode<T>> c)
    {
        if (root == null) return;
        List<BinaryTreeNode<T>> last = new ArrayList<>();
        List<BinaryTreeNode<T>> current = new ArrayList<>();
        List<BinaryTreeNode<T>> tmp = null;
        last.add(root);
        while(!last.isEmpty()) {
            for (BinaryTreeNode<T> n : last) {
                c.accept(n);
                if (n.left != null) current.add(n.left);
                if (n.right != null) current.add(n.right);
            }
            last.clear();
            tmp = last;
            last = current;
            current = tmp;
        }
    }

    public static <T> void getLevelsOfTree(
            List<List<T>> levels,
            BinaryTreeNode<T> root,
            int lvl)
    {
        if (levels == null) return;
        if (root == null) return;
        if (lvl >= levels.size()) levels.add(new ArrayList<T>());
        levels.get(lvl).add(root.val);
        lvl++;
        if (root.left != null) getLevelsOfTree(levels, root.left, lvl);
        if (root.right != null) getLevelsOfTree(levels, root.right, lvl);
    }

    public static <T> BinaryTreeNode<T> buildTree(
        String o1, List<T> t1, String o2, List<T> t2)
    {
        if (t1 == null || t2 == null) return null;
        if (t1.size() != t2.size()) return null;
        if (hasDuplicates(t1) || hasDuplicates(t2)) return null;
        if ("in".equals(o1)) {
            if ("pre".equals(o2)) {
                return buildTreePreInOrder(t2, t1);
            } else if ("post".equals(o2)) {
                return buildTreePostInOrder(t1, t2);
            }
        } else if ("in".equals(o2)) {
            if ("pre".equals(o1)) {
                return buildTreePreInOrder(t1, t2);
            } else if ("post".equals(o1)) {
                return buildTreePostInOrder(t2, t1);
            }
        }
        return null;
    }

    public static <T> BinaryTreeNode<T> buildTree_fast(
        String o1, List<T> t1, String o2, List<T> t2, T god)
    {
        if (t1 == null || t2 == null) return null;
        if (t1.size() != t2.size()) return null;
        if (hasDuplicates(t1) || hasDuplicates(t2)) return null;
        if ("in".equals(o1)) {
            if ("pre".equals(o2)) {
                return buildTreePreInOrder_fast(t2, t1, god);
            } else if ("post".equals(o2)) {
                return buildTreePostInOrder_fast(t2, t1, god);
            }
        } else if ("in".equals(o2)) {
            if ("pre".equals(o1)) {
                return buildTreePreInOrder_fast(t1, t2, god);
            } else if ("post".equals(o1)) {
                return buildTreePostInOrder_fast(t1, t2, god);
            }
        }
        return null;
    }

    private static <T> boolean hasDuplicates(List<T> l)
    {
        Set<T> set = new HashSet<>();
        for (T e : l) {
            if (!set.add(e)) {
                return true;
            }
        }
        return false;
    }

    public static <T> BinaryTreeNode<T> buildTreePreInOrder(
        List<T> pre, List<T> in)
    {
        if (pre.size() == 0 || pre.size() != in.size()) return null;
        if (pre.size() == 1) {
            return new BinaryTreeNode<T>(pre.get(0));
        }
        BinaryTreeNode<T> root = new BinaryTreeNode<>(pre.get(0));
        int in_root = in.indexOf(pre.get(0));
        root.left = buildTreePreInOrder(pre.subList(1, in_root+1),
                in.subList(0, in_root));
        root.right = buildTreePreInOrder(pre.subList(in_root+1, in.size()),
                in.subList(in_root+1, in.size()));
        return root;
    }

    public static <T> BinaryTreeNode<T> buildTreePreInOrder_fast(
        List<T> pre, List<T> in, T god)
        /*
         * ``god``, a value not exists in ``pre`` and ``in``
         */
    {
        if (pre.size() != in.size()) return null;
        return buildTreePreInOrder_helper(
                pre, new RInteger(0), in, new RInteger(0), god);
    }

    private static <T> BinaryTreeNode<T> buildTreePreInOrder_helper(
        List<T> pre, RInteger p, List<T> in, RInteger i, T bound)
    {
        if (p.val() >= pre.size()) {
            return null;
        }
        if (in.get(i.val()).equals(bound)) {
            i.add(1);
            return null;
        }
        BinaryTreeNode<T> root = new BinaryTreeNode<>(pre.get(p.val()));
        p.add(1);
        root.left = buildTreePreInOrder_helper(pre, p, in, i, root.val);
        if (!in.get(i.val()).equals(bound)) {
            root.right = buildTreePreInOrder_helper(pre, p, in, i, bound);
        } else {
            i.add(1);
        }
        return root;
    }


    public static <T> BinaryTreeNode<T> buildTreePostInOrder(
        List<T> in, List<T> post)
    {
        if (in.size() == 0 || in.size() != post.size()) return null;
        if (in.size() == 1) {
            return new BinaryTreeNode<T>(in.get(0));
        }
        BinaryTreeNode<T> root = new BinaryTreeNode<>(post.get(post.size()-1));
        int in_root = in.indexOf(post.get(post.size()-1));
        if (in_root == -1) {
            System.out.println("bingo");
        }
        root.left = buildTreePostInOrder(in.subList(0, in_root),
                post.subList(0, in_root));
        root.right = buildTreePostInOrder(in.subList(in_root+1, in.size()),
                post.subList(in_root, in.size()-1));
        return root;
    }

    public static <T> BinaryTreeNode<T> buildTreePostInOrder_fast(
        List<T> post, List<T> in, T god)
        /*
         * ``god``, a value not exists in ``post`` and ``in``
         */
    {
        if (post.size() != in.size()) return null;
        return buildTreePostInOrder_helper(
                post, new RInteger(post.size()-1),
                in, new RInteger(in.size()-1),
                god);
    }

    private static <T> BinaryTreeNode<T> buildTreePostInOrder_helper(
        List<T> post, RInteger p, List<T> in, RInteger i, T bound)
    {
        if (p.val() < 0) {
            return null;
        }
        if (in.get(i.val()).equals(bound)) {
            i.sub(1);
            return null;
        }
        BinaryTreeNode<T> root = new BinaryTreeNode<>(post.get(p.val()));
        p.sub(1);
        root.right = buildTreePostInOrder_helper(post, p, in, i, root.val);
        if (!in.get(i.val()).equals(bound)) {
            root.left = buildTreePostInOrder_helper(post, p, in, i, bound);
        } else {
            i.sub(1);
        }
        return root;
    }

    public static <T> BinaryTreeNode<T> buildTreeLevelByLevel(
            List<String> l, /* String not T, need "null" or "#"
                              to express null */
            Class<T> clazz)
    {
        if (l.size() == 0) return null;
        BinaryTreeNode<T> root = getTreeNode(l.get(0), clazz);
        Queue<BinaryTreeNode<T>> q = new LinkedList<>();
        q.offer(root);
        int idx = 1;
        while (idx < l.size() && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size && idx < l.size(); i++) {
                BinaryTreeNode<T> t = q.poll();
                t.left = getTreeNode(l.get(idx), clazz);
                if (t.left != null) q.offer(t.left);
                idx++;
                if (idx >= l.size()) break;
                t.right = getTreeNode(l.get(idx), clazz);
                if (t.right != null) q.offer(t.right);
                idx++;
            }
        }
        return root;
    }

    @SuppressWarnings("unchecked")
    private static <T> BinaryTreeNode<T> getTreeNode(String v, Class<T> clazz)
    {
        if (v == null || "null".equals(v)) return null;
        // 9 types: Integer, String, Boolean, Byte, Character, Short, Long,
        // Float, Double
        if ("java.lang.Integer".equals(clazz.getTypeName())) {
            return (BinaryTreeNode<T>)
                new BinaryTreeNode<Integer>(Integer.valueOf(v));
        } else if ("java.lang.String".equals(clazz.getTypeName())) {
            return (BinaryTreeNode<T>)
                new BinaryTreeNode<String>(v);
        } else if ("java.lang.Boolean".equals(clazz.getTypeName())) {
            return (BinaryTreeNode<T>)
                new BinaryTreeNode<Boolean>(Boolean.valueOf(v));
        } else if ("java.lang.Byte".equals(clazz.getTypeName())) {
            return (BinaryTreeNode<T>)
                new BinaryTreeNode<Byte>(Byte.valueOf(v));
        } else if ("java.lang.Character".equals(clazz.getTypeName())) {
            return (BinaryTreeNode<T>)
                new BinaryTreeNode<Character>(Character.valueOf(v.charAt(0)));
        } else if ("java.lang.Short".equals(clazz.getTypeName())) {
            return (BinaryTreeNode<T>)
                new BinaryTreeNode<Short>(Short.valueOf(v));
        } else if ("java.lang.Long".equals(clazz.getTypeName())) {
            return (BinaryTreeNode<T>)
                new BinaryTreeNode<Long>(Long.valueOf(v));
        } else if ("java.lang.Float".equals(clazz.getTypeName())) {
            return (BinaryTreeNode<T>)
                new BinaryTreeNode<Float>(Float.valueOf(v));
        } else if ("java.lang.Double".equals(clazz.getTypeName())) {
            return (BinaryTreeNode<T>)
                new BinaryTreeNode<Double>(Double.valueOf(v));
        }
        return null;
    }

}
