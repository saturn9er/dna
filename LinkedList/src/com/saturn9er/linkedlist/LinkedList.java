package com.saturn9er.linkedlist;

import java.util.NoSuchElementException;

/**
 * The class implements linked list data structure.
 * This class provides methods for prepending/appending nodes,
 * and getting/removing nodes by index. This class employs generics
 * to be able to link together nodes of any particular type.
 * @author Roman Romankov (saturn9er)
 */
public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    /**
     * Returns head {@code Node<E>} of this linked list if not null.
     */
    public Node<E> getHead() {
        if (head == null)
            throw new NoSuchElementException();
        else
            return head;
    }

    /**
     * Returns tail {@code Node<E>} of this linked list if not null.
     */
    public Node<E> getTail() {
        if (tail == null)
            throw new NoSuchElementException();
        else
            return tail;
    }

    public int getSize() {
        return size;
    }

    /**
     * Links element {@code e} as a head.
     */
     public Node<E> prepend(E e) {
         Node<E> node = new Node<E>(e, null, head);

         if (isEmpty())
             tail = node;
         else
             head.setPrevious(node);

         head = node;
         size++;

         return node;
     }

    /**
     * Links element {@code e} as a tail.
     */
    public Node<E> append(E e) {
        Node<E> node = new Node<E>(e, tail, null);

        if (isEmpty())
            head = node;
        else
            tail.setNext(node);

        tail = node;
        size++;

        return node;
    }

    /**
     * Returns a {@code Node<E>} object located at specific index
     */
    public Node<E> get(int index) {
        if (index >= size)
            throw new NoSuchElementException();

        if (index < (size >> 1)) {
            Node<E> n = head;
            for (int i = 0; i < index; i++)
                n = n.next;
            return n;
        } else {
            Node<E> n = tail;
            for (int i = size - 1; i > index; i--)
                n = n.previous;
            return n;
        }
    }

    /**
     * Removes a node located at specific index from this list
     * @return true if node was removes, false otherwise
     */
    public boolean remove(int index) {
        if (isEmpty()) return false;

        Node<E> node = get(index);

        if (node.hasPrevious()) // non-head
            node.previous.next = node.getNext();
        else // head
            head = node.getNext();

        if (node.hasNext()) // non-tail
            node.next.previous = node.getPrevious();
        else // tail
            tail = node.getPrevious();

        node.setValue(null);
        node.setNext(null);
        node.setPrevious(null);

        size--;

        return true;
    }

    /**
     * Assumes that this list is empty if it's head AND tail are null.
     */
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public static class Node<E> {
        private E value;
        private Node<E> previous;
        private Node<E> next;

        public Node(E value, Node<E> previous, Node<E> next) {
            setValue(value);
            setPrevious(previous);
            setNext(next);
        }

        public void setValue(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

        public boolean hasPrevious() {
            return this.previous != null;
        }

        public boolean hasNext() {
            return this.next != null;
        }
    }

}
