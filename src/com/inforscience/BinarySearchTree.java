package com.inforscience;

import java.util.LinkedList;

public class BinarySearchTree<E extends Comparable<E>> {
    private static class Node<E> {
        E item;
        Node<E> left;
        Node<E> right;

        Node(E e) {
            item = e;
        }
    }

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    private Node<E> insert(Node<E> node, E e) {
        if (node == null) {
            return new Node<E>(e);
        } else if (e.compareTo(node.item) < 0) {
            node.left = insert(node.left, e);
        } else {
            node.right = insert(node.right, e);
        }

        return node;
    }

    public void insert(E e) {
        root = insert(root, e);
    }

    public void bfs() {
        if (root == null) { return; }
        LinkedList<Node<E>> Q = new LinkedList<Node<E>>();
        Q.add(root);
        while (!Q.isEmpty()) {
            Node<E> next = Q.removeFirst();
            System.out.print(next.item + " ");
            if (next.left != null) {
                Q.add(next.left);
            }

            if (next.right != null) {
                Q.add(next.right);
            }
        }
    }

    private void dfs(Node<E> node) {
        if (node.left != null) {
            dfs(node.left);
        }

        System.out.print(node.item + " ");

        if (node.right != null) {
            dfs(node.right);
        }
    }

    public void dfs() {
        dfs(root);
    }
}
