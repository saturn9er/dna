package com.saturn9er.stack;

import com.saturn9er.linkedlist.LinkedList;

import java.util.NoSuchElementException;

/**
 * This class implements stack data structure using
 * my linked list package. It provides all basic operations
 * for stack: push, pop, peek(top).
 * It lets a client to push any object on the stack {@code Object}.
 * Every stack has a constant maximum size.
 * @author Roman Romankov (saturn9er)
 */
public class Stack {

    private LinkedList<Object> objects = new LinkedList<>();
    private int maxSize;

    public Stack(int maxSize)
    {
        this.maxSize = maxSize;
    }

    public int getSize() {
        return objects.getSize();
    }

    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Pushes an {@code Object} on the stack if it isn't fed up with them:)
     * @returns boolean depending on success of pushing an object on the stack
     */
    public boolean push(Object element)
    {
        if (getSize() < getMaxSize()) {
            objects.append(element);
            return true;
        }

        return false;
    }

    /**
     * Returns top object from the stack and also removes it from the stack.
     */
    public Object pop()
    {
        if (getSize() == 0) throw new NoSuchElementException("The stack is empty.");

        int tailIndex = objects.getSize() - 1;
        Object object = objects.getTail().getValue();
        objects.remove(tailIndex);

        return object;
    }

    /**
     * Returns top object from the stack without removing it.
     */
    public Object peek()
    {
        return objects.getTail().getValue();
    }

    public boolean isEmpty()
    {
        return objects.isEmpty();
    }
}
