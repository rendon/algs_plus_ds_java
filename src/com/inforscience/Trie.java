package com.inforscience;

import java.util.ArrayList;
public class Trie {
    private Node root, current;
    public Trie(ArrayList<String> dict) {
        root = new Node('\0');
        current = root;
        for (String word : dict) {
            insert(root, word, 0);
        }
    }

    private void insert(Node node, String str, int pos) {
        if (pos == str.length()) {
            return;
        }

        char k = str.charAt(pos);
        Node next = node.getNext(k);
        if (next == null) {
            next = new Node(k);
            if (pos + 1 == str.length()) {
                next.setIsEnd(true);
            }
            node.put(k, next);
        }

        insert(next, str, pos + 1);
    }

    public Node getCurrent() {
        return current;
    }

    public void setCurrent(Node current) {
        this.current = current;
    }

    public boolean move(char k) {
        if (current.getNext(k) == null) {
            return false;
        }

        current = current.getNext(k);
        return true;
    }

    public boolean isEndOfWord() {
        return current.isEnd();
    }

    public void reset() {
        current = root;
    }
}
