package calculator;

import util.Stack;

import java.lang.*;

/**
 * Abstract class for the operators
 * Contains the binary and unary operations
 * The binary operations are addition, substraction, multiplication and division
 * The unary operations are square root, reciprocal, opposite and square
 * @author Rémy Bleuer
 * @author Kilian Demont
 */
abstract class Operator {
    static Addition addition = new Addition();
    static Substraction substraction = new Substraction();
    static Multiplication multiplication = new Multiplication();
    static Division division = new Division();
    static Enter enter = new Enter();
    static Number[] numbers = new Number[10];
    static Point point = new Point();
    static ClearEntry clearEntry = new ClearEntry();
    static Clear clear = new Clear();
    static Recpirocal recpirocal = new Recpirocal();
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

    void binaryOperation(State state, BinaryOperation operation) {
        if (state.isError()) {
            return; // Ne pas effectuer l'opération si une erreur est déjà présente
        }

        Stack<String> a = state.getStack();
        if (!a.isEmpty()) {
            double operand1 = Double.parseDouble(state.getCurrentValue());
            double operand2 = Double.parseDouble(a.pop());
            double result = operation.apply(operand1, operand2);
            if (result != result) { //vérifie si result n'est pas un nombre
                state.setError(true);
            } else {
                state.setCurrentValue(String.valueOf(result));
                state.setOperationPerformed(true);
            }
        } else
            state.setError(true);
    }

    interface BinaryOperation {
        double apply(double operand1, double operand2);
    }

    void unaryOperation(State state, UnaryOperation operation) {
        if (state.isError() || operation == null) {
            return; // Ne pas effectuer l'opération si une erreur est déjà présente
        }

        double operand = Double.parseDouble(state.getCurrentValue());
        double result = operation.apply(operand);
        if (result != result) { //vérifie si result n'est pas un nombre
            state.setError(true);
        } else {
            state.setCurrentValue(String.valueOf(result));
            state.setOperationPerformed(true);
        }
    }

    interface UnaryOperation {
        double apply(double operand);
    }

    abstract void execute(State state);
}