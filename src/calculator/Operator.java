package calculator;

import util.Stack;

import java.lang.*;

/**
 * Abstract class for the operators
 * Contains the binary and unary operations
 * The binary operations are addition, subtraction, multiplication and division
 * The unary operations are square root, reciprocal, opposite and square
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 */
abstract class Operator {
    static Addition addition = new Addition();
    static Subtraction subtraction = new Subtraction();
    static Multiplication multiplication = new Multiplication();
    static Division division = new Division();
    static Enter enter = new Enter();
    static Number[] numbers = new Number[10];
    static Point point = new Point();
    static ClearEntry clearEntry = new ClearEntry();
    static Clear clear = new Clear();
    static Reciprocal reciprocal = new Reciprocal();
    static Opposite opposite = new Opposite();
    static SquareRoot squareRoot = new SquareRoot();
    static Square square = new Square();
    static Backspace backspace = new Backspace();
    static MemoryStore memoryStore = new MemoryStore();
    static MemoryRecall memoryRecall = new MemoryRecall();

    // Initialization of the Number instances
    static {
        for (int i = 0; i < 10; i++) {
            numbers[i] = new Number(String.valueOf(i));
        }
    }


    /**
     * Performs a binary operation on the given state using the provided operation.
     *
     * @param state     The current state of the calculator.
     * @param operation The binary operation to be performed.
     */
    void binaryOperation(State state, BinaryOperation operation) {
        if (state.isError()) {
            return;
        }

        Stack<String> a = state.getStack();
        if (!a.isEmpty()) {
            double operand1 = Double.parseDouble(state.getCurrentValue());
            double operand2 = Double.parseDouble(a.pop());
            double result = operation.apply(operand1, operand2);
            if (Double.isNaN(result)) {
                state.setError(true);
            } else {
                state.setCurrentValue(String.valueOf(result));
                state.setOperationPerformed(true);
            }
        } else
            state.setError(true);
    }

    /**
     * Represents a binary operation that can be performed on a calculator's state.
     */
    interface BinaryOperation {
        /**
         * Applies the binary operation on two operands.
         *
         * @param operand1 The first operand.
         * @param operand2 The second operand.
         * @return The result of the binary operation.
         */
        double apply(double operand1, double operand2);
    }

    /**
     * Performs a unary operation on the given state using the provided operation.
     *
     * @param state     The current state of the calculator.
     * @param operation The unary operation to be performed.
     */
    void unaryOperation(State state, UnaryOperation operation) {
        if (state.isError() || operation == null) {
            return;
        }

        double operand = Double.parseDouble(state.getCurrentValue());
        double result = operation.apply(operand);
        if (Double.isNaN(result)) {
            state.setError(true);
        } else {
            String s = String.valueOf(result);
            // remove trailing zeros
            // https://stackoverflow.com/questions/14984664/remove-trailing-zero-in-java
            s = s.contains(".") ? s.replaceAll("0*$","").replaceAll("\\.$","") : s;

            state.setCurrentValue(s);
            state.setOperationPerformed(true);
        }
    }

    /**
     * Represents a unary operation that can be performed on a calculator's state.
     */
    interface UnaryOperation {
        /**
         * Applies the unary operation on an operand.
         *
         * @param operand The operand.
         * @return The result of the unary operation.
         */
        double apply(double operand);
    }

    /**
     * Executes the operator on the given state.
     *
     * @param state The current state of the calculator.
     */
    abstract void execute(State state);
}