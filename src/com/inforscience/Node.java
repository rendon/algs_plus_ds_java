package com.inforscience;
public class Node {
    private char key;
    private boolean isEnd = false;
    private Node[] next = new Node[256];
    public Node(char key) {
        this.key = key;
        this.isEnd = false;
    }

    public char getKey() { return key; }
    public void setKey(char k) {
        key = k;
    }
    public boolean isEnd() { return isEnd; }
    public void setIsEnd(boolean value) {
        isEnd = value;
    }

    public Node getNext(char k) {
        return next[(int)k];
    }

    public void put(char k, Node node) {
        next[k] = node;
    }
}
