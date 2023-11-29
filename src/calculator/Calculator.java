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

        System.out.println("java" + getClass().getSimpleName());

        do {
            System.out.print("> ");
            input = scanner.nextLine();
            processInput(input);
        } while (!input.equalsIgnoreCase("exit"));

        System.out.println("Bye!");
    }

    private void processInput(String input) {
        if (isNumeric(input)) {
            state.getStack().push(input);
            state.setCurrentValue(input);
            printState();
        } else {
            Operator operator = getOperator(input);
            if (operator != null) {
                if (state.getStack().size() < 1) {
                    System.out.println("Need more numbers in the stack");
                    return;
                }

                state.getStack().pop();
                operator.execute(state);
                String tmp = state.getCurrentValue();
                state.getStack().push(tmp);
                printState();
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

            case "exit":
                return new Operator() {
                    @Override
                    void execute(State state) {
                        // For exit command
                    }
                };
            default:
                return null;
        }
    }

    private void printState() {
        System.out.println(state.getStack());
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
