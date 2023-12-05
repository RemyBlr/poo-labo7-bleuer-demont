package calculator;

import java.util.Scanner;

/**
 * Calculator class
 * Use the Operator class and the State class to create a calculator in the terminal
 * The calculator can do basic operations (+, -, *, /, sqrt, reciprocal, opposite, square)
 * Some operations are not useful (point, enter, backspace, etc.)
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 */
public class Calculator {
    private final State state;

    /**
     * Constructs a Calculator object with an initial state.
     */
    public Calculator() {
        this.state = new State();
    }

    /**
     * Runs the calculator, allowing the user to input commands in the terminal.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("java " + getClass().getSimpleName());

        do {
            System.out.print("> ");
            input = scanner.nextLine();
            if (!handleExit(input))
                processInput(input);
        } while (!input.equalsIgnoreCase("exit"));
    }

    /**
     * Checks if the input is "exit" and handles the exit scenario.
     *
     * @param input The user input.
     * @return True if the input is "exit," false otherwise.
     */
    private boolean handleExit(String input) {
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Bye!");
            return true;
        }
        return false;
    }

    /**
     * Processes the user input by parsing and executing commands.
     *
     * @param input The user input.
     */
    private void processInput(String input) {
        // In case of multiple inputs
        // It's possible to write : 1 2 3 + + => 6
        if(input.contains(" ")){
            String[] inputs = input.split(" ");
            for(String s : inputs){
                processInput(s);
            }
            return;
        } else if (!input.contains(".") && isNumeric(input)) {
            input += ".0";
        }

        if (isNumeric(input)) {
            state.getStack().push(input);
            state.setCurrentValue(input);
            printStack();
        } else {
            Operator operator = getOperator(input);
            if (operator != null) {
                state.getStack().pop();

                operator.execute(state);
                String tmp = state.getCurrentValue();
                state.getStack().push(tmp);
                printStack();
            } else {
                System.out.println("Enter a number or a valid operator");
            }
        }
    }

    /**
     * Check if a String is Numeric.
     * This code comes from : https://www.baeldung.com/java-check-string-number
     *
     * @param strNum The String to check.
     * @return true if the String is numeric, false otherwise.
     *
     */
    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    /**
     * Gets the Operator corresponding to the input string.
     *
     * @param input The input string representing an operator.
     * @return The Operator object or null if the input is not a valid operator.
     */
    private Operator getOperator(String input) {
        return switch (input.toLowerCase()) {
            case "+" -> Operator.addition;
            case "-" -> Operator.subtraction;
            case "*" -> Operator.multiplication;
            case "/" -> Operator.division;
            case "sqrt" -> Operator.squareRoot;
            case "reciprocal" -> Operator.reciprocal;
            case "opposite" -> Operator.opposite;
            case "square" -> Operator.square;
            case "clear" -> Operator.clear;
            case "ms" -> Operator.memoryStore;
            case "mr" -> Operator.memoryRecall;
            default -> null;
        };
    }

    /**
     * Prints the current stack state to the terminal.
     */
    private void printStack() {
        System.out.println(state.getStack());
    }

    /**
     * Main method to start the calculator application in the terminal.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
