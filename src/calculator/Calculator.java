package calculator;

import java.util.Scanner;

/**
 * Calculator class
 * Use the Operator class and the State class to create a calculator in the terminal
 * The calculator can do basic operations (+, -, *, /, sqrt, reciprocal, opposite, square)
 * Some operrations are not useful (point, enter, backspace, etc.)
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 */
public class Calculator {
    private State state;

    public Calculator() {
        this.state = new State();
    }

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

    private boolean handleExit(String input) {
        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Bye!");
            return true;
        }
        return false;
    }

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

    //https://www.baeldung.com/java-check-string-number
    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private Operator getOperator(String input) {
        switch (input.toLowerCase()) {
            case "+":
                return Operator.addition;
            case "-":
                return Operator.substraction;
            case "*":
                return Operator.multiplication;
            case "/":
                return Operator.division;
            case "sqrt":
                return Operator.squareRoot;
            case "reciprocal":
                return Operator.recpirocal;
            case "opposite":
                return Operator.opposite;
            case "square":
                return Operator.square;
            case "clear":
                return Operator.clear;
            case "ms":
                return Operator.memoryStore;
            case "mr":
                return Operator.memoryRecall;
            default:
                return null;
        }
    }

    private void printStack() {
        System.out.println(state.getStack());
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
