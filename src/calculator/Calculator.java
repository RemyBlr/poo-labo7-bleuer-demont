package calculator;

import java.util.Scanner;

public class Calculator {
    private State state;

    public Calculator() {
        this.state = new State();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println(getClass());

        do {
            System.out.print("> ");
            input = scanner.nextLine();
            processInput(input);
        } while (!input.equalsIgnoreCase("exit"));

        System.out.println("Calculator is exiting.");
    }

    private void processInput(String input) {
        if (isNumeric(input)) {
            state.setCurrentValue(input);
            state.getStack().push(input);
            printState();
        } else {
            Operator operator = getOperator(input);
            if (operator != null) {
                operator.execute(state);
                String tmp = state.getCurrentValue();
                state.getStack().push(tmp);
                printState();
            } else {
                System.out.println("Please enter a number or a valid operator");
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
            case "enter":
                return Operator.enter;
            case "clear":
                return Operator.clear;
            case "ce":
                return Operator.clearEntry;
            case ".":
                return Operator.point;
            case "bs":
                return Operator.backspace;
            case "ms":
                return Operator.memoryStore;
            case "mr":
                return Operator.memoryRecall;
            case "exit":
                return new Operator() {
                    @Override
                    void execute(State state) {
                        // Do nothing for exit command
                    }
                };
            default:
                return null;
        }
    }

    private void printState() {
        System.out.println("stack : " + state.getStack());
        System.out.println("current val : " + state.getCurrentValue());
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
