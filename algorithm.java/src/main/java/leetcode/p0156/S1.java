package leetcode.p0156;

import java.util.*;

import leetcode.libs.RTree;

class S1 implements Solution {
    public RTree.BinaryTreeNode<Integer>
        upsideDownBinaryTree(RTree.BinaryTreeNode<Integer> root) {
        if (root == null) return null;
        RTree.BinaryTreeNode<Integer> l, r, ll, lr;
        l = root.left;
        r = root.right;
        root.left = null;
        root.right = null;
        while (l != null) {
            ll = l.left;
            lr = l.right;
            l.left = r;
            l.right = root;
            root = l;
            r = lr;
            l = ll;
        }
        return root;
    }
}
