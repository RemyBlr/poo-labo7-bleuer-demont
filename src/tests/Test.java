package tests;

import util.Stack;
import java.util.Arrays;

/**
 * This class provides a test program for the Stack class.
 * It demonstrates the basic operations of pushing, popping,
 * and clearing elements in a stack, as well as obtaining
 * array representation and using an iterator.
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 *
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Print the stack
        System.out.println("Stack: " + stack);

        // Pop an element
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);

        // Print the stack after popping
        System.out.println("Stack after popping: " + stack);

        // Get array representation
        Object[] array = stack.toArray();
        System.out.print("Stack as array: ");
        System.out.println(Arrays.toString(array));

        // Use an iterator
        System.out.print("Stack using iterator: ");
        for (Integer item : stack) {
            System.out.print(item + " ");
        }

        // Clear the stack
        stack.clear();

        // Print the stack after clearing
        System.out.println("\nStack after clearing: " + stack);
    }
}
