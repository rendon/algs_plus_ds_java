package com.inforscience;
import java.util.*;

/** Double-linked list.*/
public class LinkedList<E> {
    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;
        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    private Node<E> first, last;
    private int size = 0;
    public LinkedList() {
    }

    public int size() {
        return size;
    }

    public void addLast(E e) {
        Node<E> l = last;
        last = new Node<E>(l, e, null);
        if (l == null) {
            first = last;
        } else {
            l.next = last;
        }
        size++;
    }

    public void add(E e) {
        addLast(e);
    }

    public void addFirst(E e) {
        Node<E> f = first;
        first = new Node<E>(null, e, f);
        if (f == null) {
            last = first;
        } else {
            f.prev = first;
        }
        size++;
    }

    public E removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        E e = first.item;
        Node<E> next = first.next;
        first.item = null; // It might help the GC :)
        first.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }

        size--;
        return e;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }

        E e = last.item;
        Node<E> prev = last.prev;
        last.item = null; // It might help the GC :)
        last.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }

        size--;
        return e;
    }

    private void unlink(Node<E> x) {
        //assert x != null;
        Node<E> prev = x.prev;
        Node<E> next = x.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        // It might help the GC, optional.
        x.item = null;
        x.prev = null;
        x.next = null;
        size--;
    }

    public boolean remove(Object o) {
        if (first == null) {
            return false;
        }

        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }

        return false;
    }

    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.item;
    }

    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }

        return last.item;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = first;
        while (node != null && index > 0) {
            node = node.next;
            index--;
        }

        return node.item;
    }
}
