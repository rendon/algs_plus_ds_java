package com.inforscience;
@SuppressWarnings("unchecked")
public class HashTableLP<Key, Value> {
    private int M = 1001177;
    private int size = 0;
    private Key[] K = (Key[]) new Object[M];
    private Value[] V = (Value[]) new Object[M];

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        if (key == null) { return; }
        int i;
        for (i = hash(key); K[i] != null; i = (i + 1) % M) {
            if (K[i].equals(key)) {
                break;
            }
        }

        K[i] = key;
        V[i] = val;
    }

    public Value get(Key key) {
        if (key == null) { return null; }
        for (int i = hash(key); K[i] != null; i = (i + 1) % M) {
            if (K[i].equals(key)) {
                return V[i];
            }
        }

        return null;
    }
}
