import java.util.*;

public class LinkedList<E> {
    private class Node<E> {
        private E e;
        private Node<E> next;
        Node() {
            next = null;
        }

        Node(E e) {
            this.e = e;
            next = null;
        }
    }

    private Node<E> head, tail;
    private int size;
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addLast(E e) {
        Node<E> node = new Node<E>(e);
        if (tail == null) { // Empty list
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add(E e) {
        addLast(e);
    }

    public void addFirst(E e) {
        Node<E> node = new Node<E>(e);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        E e = head.e;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<E> next = head.next;
            head = null;
            head = next;
        }

        size--;
        return e;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        E e = tail.e;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<E> node = head;
            while (node.next != tail) {
                node = node.next;
            }

            node.next = tail.next;
            tail = null;
            tail = node;
        }

        size--;
        return e;
    }

    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }

        Node<E> node = head;
        while (node.next != null && !node.next.e.equals(o)) {
            node = node.next;
        }

        if (node.next == null) {
            return false;
        }

        Node<E> next = node.next;
        node.next = next.next;
        next = null;

        size--;
        return true;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        return head.e;
    }

    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        return tail.e;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = head;
        while (node != null && index > 0) {
            node = node.next;
            index--;
        }

        return node.e;
    }
}
