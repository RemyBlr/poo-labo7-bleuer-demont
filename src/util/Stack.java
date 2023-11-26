/*
--------------------------------------------------------------------------------
File name		 : Stack.java

Author(s)		 : Bleuer Rémy and Demont Kilian

Creation date    : 16.11.2023

Description      :  Represents a stack class that allows to represent this data
                    structure with these main functionalities. The class
                    includes methods for manage the stack and convert it into
                    String or array.

--------------------------------------------------------------------------------
*/

package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a stack with specified size.
 */
public class Stack<T> implements Iterable<T> {

    private Node<T> top;
    private int size;

    public void clear() {
        top = null;
        size = 0;
    }

    // Node class for holding data and linking nodes
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    // Constructor to initialize an empty stack
    public Stack() {
        top = null;
        size = 0;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the size of the stack
    public int size() {
        return size;
    }

    /**
     * Push an item onto the stack
     *
     * @param item value to put on top of the stack
    */
     public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop an item from the stack
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // Get a string representation of the stack
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = top;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    // Get an array representation of the stack
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = top;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    // Get an array representation of the stack
    public String[] toArrayOfString() {
        String[] array = new String[size];
        Node<T> current = top;
        for (int i = 0; i < size; i++) {
            array[i] = current.data.toString();
            current = current.next;
        }
        return array;
    }

    // Iterator implementation for the stack
    private class StackIterator implements Iterator<T> {
        private Node<T> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    // Provide an iterator for the stack
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
}
