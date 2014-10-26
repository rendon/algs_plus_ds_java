package com.inforscience;
import java.util.Queue;
import java.util.LinkedList;

public class BalancedBinarySearchTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED     = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private boolean color;
        Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.color = RED;
        }
    }

    public BalancedBinarySearchTree() {
        root = null;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    private boolean isRed(Node h) {
        if (h == null) {
            return false;
        }

        return h.color == RED;
    }

    private Node insert(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val);
        }

        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = insert(h.left, key, val);
        } else if (cmp > 0) {
            h.right = insert(h.right, key, val);
        } else {
            h.val = val;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }

        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        return h;
    }

    public void insert(Key key, Value val) {
        root = insert(root, key, val);    
    }



    private Value get(Node h, Key key) {
        if (h == null) {
            return null;
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            return get(h.left, key);
        } else if (cmp > 0) {
            return get(h.right, key);
        } else {
            return h.val;
        }
    }

    public Value get(Key key) {
        if (key == null) {
            return null;
        }

        return get(root, key);
    }


    public void bfs() {
        if (root == null) { return; }
        Queue<Node> Q = new LinkedList<Node>();
        Queue<Integer> L = new LinkedList<Integer>();

        Q.offer(root);
        L.offer(1);
        int prev = 1;
        while (!Q.isEmpty()) {
            Node next = Q.poll();
            int level = L.poll();
            if (level != prev) {
                System.out.println();
            }
            prev = level;
            System.out.print(next.val + " ");

            if (next.left != null) {
                Q.offer(next.left);
                L.offer(level + 1);
            }

            if (next.right != null) {
                Q.offer(next.right);
                L.offer(level + 1);
            }
        }

        System.out.println("Levels = " + prev);
    }
}
