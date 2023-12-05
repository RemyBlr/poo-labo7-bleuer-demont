package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a stack data structure with specified size.
 * Supports basic operations like push, pop, clear, and provides
 * methods for obtaining string or array representations.
 *
 * @param <T> The type of elements in the stack.
 * @author Rémy Bleuer
 * @author Kilian Demont
 */
public class Stack<T> implements Iterable<T> {

    private Node<T> top;
    private int size;

    /**
     * Clears the stack by setting top to null and size to 0.
     */
    public void clear() {
        top = null;
        size = 0;
    }

    /**
     * Node class for holding data and linking nodes
     *
     * @param <T> The type of elements in the stack.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        /**
         * Constructs a node with the given data.
         *
         * @param data The data to be stored in the node.
         */
         Node(T data) {
            this.data = data;
        }
    }

    /**
     * Constructs an empty stack.
     */
    public Stack() {
        top = null;
        size = 0;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Gets the size of the stack.
     *
     * @return The size of the stack.
     */
    public int size() {
        return size;
    }

    /**
     * Pushes an item onto the stack.
     *
     * @param item The value to put on top of the stack.
     */
     public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Pops an item from the stack.
     *
     * @return The popped item.
     * @throws NoSuchElementException If the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    /**
     * Gets a string representation of the stack.
     *
     * @return A string representation of the stack.
     */
    @Override
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

    /**
     * Gets an array representation of the stack.
     *
     * @return An array representation of the stack.
     */
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = top;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

     /**
     * Gets a string array representation of the stack.
     *
     * @return A string array representation of the stack.
     */
    public String[] toArrayOfString() {
        String[] array = new String[size];
        Node<T> current = top;
        for (int i = 0; i < size; i++) {
            array[i] = current.data.toString();
            current = current.next;
        }
        return array;
    }

    /**
     * Iterator implementation for the Stack class.
     * Allows iterating over the elements of the stack from the top to the bottom.
     */
    private class StackIterator implements Iterator<T> {
        private Node<T> current = top;

        /**
         * Check if the iteration has more elements (nodes).
         * @return A boolean, true if the iteration has more elements, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration and advances the iterator position.
         * @return the next element in the iteration.
         * @throws NoSuchElementException if there are no more elements to iterate.
         */
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

    /**
     * Provides an iterator for the stack.
     *
     * @return An iterator for the stack.
     */
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
}
