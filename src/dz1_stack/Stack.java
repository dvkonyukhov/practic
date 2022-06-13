package dz1_stack;

import java.util.EmptyStackException;

public class Stack<E> {

    private int size;
    private Object[] elements;

    public Stack() {
        elements = new Object[1];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void push(E item) {
        int nextSize = size + 1;
        Object[] newElements = new Object[nextSize];
        System.arraycopy(elements, 0, newElements, 0, size);
        newElements[nextSize - 1] = item;
        elements = newElements;
        size = nextSize;
    }

    public E pop() {
        int nextSize = size - 1;
        E item;
        if (getSize() == 0)
            throw new EmptyStackException();
        item = (E) elements[elements.length - 1];
        Object[] newElements = new Object[nextSize];
        System.arraycopy(elements, 0, newElements, 0, nextSize);
        elements = newElements;
        size = nextSize;
        return item;
    }

}