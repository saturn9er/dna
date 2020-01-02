import java.util.NoSuchElementException;

/**
 * The class implements linked list data structure.
 * This class provides methods for prepending/appending nodes,
 * and getting/removing nodes by index. This class employs generics
 * to be able to link together nodes of any particular type.
 * @author Roman Romankov (saturn9er)
 */
public class LinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size = 0;

    /**
     * Links element {@code e} as a head.
     */
     public Node<E> prepend(E e) {
         Node<E> node = new Node<E>(e, null, head);

         if (isEmpty())
             tail = node;
         else
             head.previous = node;

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
            tail.next = node;

        tail = node;
        size++;

        return node;
    }

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
     * Returns tail {@code Node<E>} of this linked list if not null.
     */
    public Node<E> getTail() {
        if (tail == null)
            throw new NoSuchElementException();
        else
            return tail;
    }

    /**
     * Removes a node located at specific index from this list
     * @return true if node was removes, false otherwise
     */
    public boolean remove(int index) {
        if (isEmpty()) return false;

        Node<E> node = get(index);

        if (node.hasPrevious()) // non-head
            node.previous.next = node.next;
        else // head
            head = node.next;

        if (node.hasNext()) // non-tail
            node.next.previous = node.previous;
        else // tail
            tail = node.previous;

        node.value = null;
        node.next = null;
        node.previous = null;

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
        E value;
        Node<E> previous;
        Node<E> next;

        public Node(E value, Node<E> previous, Node<E> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        public boolean hasPrevious() {
            return this.previous != null;
        }

        public boolean hasNext() {
            return this.next != null;
        }
    }

}
