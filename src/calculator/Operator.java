package calculator;

import util.Stack;

import java.lang.*;

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
    static squareRoot squareRoot = new squareRoot();
    static Square square = new Square();
    static Backspace backspace = new Backspace();
    static MemoryStore memoryStore = new MemoryStore();
    static MemoryRecall memoryRecall = new MemoryRecall();

    // Initialization of the Number instances
    static {
        for (int i = 0; i < 10; i++) {
            numbers[i] = new Number(i);
        }
    }

    void binaryOperation(State state, BinaryOperation operation) {
        Stack<Double> a = state.getStack();
        if (!a.isEmpty()) {
            // Careful: the first operand is the second popped from the stack
            double operand1 = state.getCurrentValue();
            double operand2 = a.pop();
            double result = operation.apply(operand1, operand2);
            state.setCurrentValue(result);
            state.setOperationPerformed(true);
        } else
            state.setError(true);
    }

    interface BinaryOperation {
        double apply(double operand1, double operand2);
    }

    void unaryOperation(State state, UnaryOperation operation) {
        double operand = state.getCurrentValue();
        double result = operation.apply(operand);
        state.setCurrentValue(result);
        state.setOperationPerformed(true);
    }

    interface UnaryOperation {
        double apply(double operand);
    }

    abstract void execute(State state);
}

// ------------------ Binary operations ------------------
class Addition extends Operator {
    @Override
    void execute(State state) {
        binaryOperation(state, (operand1, operand2) -> operand1 + operand2);
    }
}

class Substraction extends Operator {
    @Override
    void execute(State state) {
        binaryOperation(state, (operand1, operand2) -> operand1 - operand2);
    }
}

class Multiplication extends Operator {
    @Override
    void execute(State state) {
        binaryOperation(state, (operand1, operand2) -> operand1 * operand2);
    }
}

class Division extends Operator {
    @Override
    void execute(State state) {
        binaryOperation(state, (operand1, operand2) -> operand1 / operand2);
    }
}

// ------------------ Unary operations ------------------
class Recpirocal extends Operator {
    @Override
    void execute(State state) {
        unaryOperation(state, operand -> 1 / operand);
    }
}

class Opposite extends Operator {
    @Override
    void execute(State state) {
        unaryOperation(state, operand -> -operand);
    }
}

class squareRoot extends Operator {
    @Override
    void execute(State state) {
        unaryOperation(state, Math::sqrt);
    }
}

class Square extends Operator {
    @Override
    void execute(State state) {
        unaryOperation(state, operand -> operand * operand);
    }
}

// ------------------ Numbers ------------------
class Number extends Operator {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    void execute(State state) {
        if (state.isOperationPerformed()) {
            state.getStack().push(state.getCurrentValue());
            state.setCurrentValue(0);
            state.setOperationPerformed(false);
        }
        state.setCurrentValue(state.getCurrentValue() * 10 + value);
    }
}

// ------------------ Clear ------------------
class ClearEntry extends Operator {
    @Override
    void execute(State state) {
        state.setCurrentValue(0);
    }
}

class Clear extends Operator {
    @Override
    void execute(State state) {
        state.clear();
    }
}

// ------------------ Memory ------------------
class MemoryStore extends Operator {
    @Override
    void execute(State state) {
        state.setMemory(state.getCurrentValue());
    }
}

class MemoryRecall extends Operator {
    @Override
    void execute(State state) {
        if (state.getMemory() != 0) // je sais pas si besoin, si envie de stocker 0 pourquoi pas
            state.setCurrentValue(state.getMemory());
    }
}

// ------------------ Misc ------------------
class Enter extends Operator {
    @Override
    void execute(State state) {
        state.getStack().push(state.getCurrentValue());
        state.setCurrentValue(0);
    }
}

class Point extends Operator {
    @Override
    void execute(State state) {

    }
}

class Backspace extends Operator {
    @Override
    void execute(State state) {

    }
}