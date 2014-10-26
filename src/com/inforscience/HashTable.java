package com.inforscience;

public class HashTable<Key, Value> {
    private static class Node {
        private Object key;
        private Object val;
        private Node next;
        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private int M = 1001177;
    private int size;
    private Node[] T = new Node[M];
    public HashTable() {
        size = 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        if (key == null) { return; }
        int index = hash(key);
        for (Node x = T[index]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }

        T[index] = new Node(key, val, T[index]);
    }

    @SuppressWarnings("unchecked")
    public Value get(Key key) {
        if (key == null) { return null; }
        int index = hash(key);
        for (Node x = T[index]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return (Value) x.val;
            }
        }

        return null;
    }
}
