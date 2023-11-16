package tests;

import util.Stack;
import java.util.Arrays;

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
    }
}
