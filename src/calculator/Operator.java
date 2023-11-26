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

    void executeBinaryOperation(State state, BinaryOperation operation) {
        Stack<Double> a = state.getStack();
        if (a.size() >= 2) {
            // Careful: the first operand is the second popped from the stack
            double operand2 = a.pop();
            double operand1 = a.pop();
            double result = operation.apply(operand1, operand2);
            a.push(result);
        } else
            state.setError(true);
    }

    interface BinaryOperation {
        double apply(double operand1, double operand2);
    }

    abstract void execute(State state);
}

class Addition extends Operator {
    @Override
    void execute(State state) {
        executeBinaryOperation(state, (operand1, operand2) -> operand1 + operand2);
    }
}

class Substraction extends Operator {
    @Override
    void execute(State state) {
        executeBinaryOperation(state, (operand1, operand2) -> operand1 - operand2);
    }
}

class Multiplication extends Operator {
    @Override
    void execute(State state) {
        executeBinaryOperation(state, (operand1, operand2) -> operand1 * operand2);
    }
}

class Division extends Operator {
    @Override
    void execute(State state) {
        executeBinaryOperation(state, (operand1, operand2) -> operand1 / operand2);
    }
}

class Number extends Operator {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    void execute(State state) {
        state.setCurrentValue(state.getCurrentValue() * 10 + value);
    }
}

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

class ClearEntry extends Operator {
    @Override
    void execute(State state) {
        // TODO
    }
}

class Clear extends Operator {
    @Override
    void execute(State state) {
        // TODO
    }
}

class Recpirocal extends Operator {
    @Override
    void execute(State state) {
        // TODO
    }
}

class Opposite extends Operator {
    @Override
    void execute(State state) {
        // TODO
    }
}

class squareRoot extends Operator {
    @Override
    void execute(State state) {
        // TODO
    }
}

class Square extends Operator {
    @Override
    void execute(State state) {
        // TODO
    }
}

class Backspace extends Operator {
    @Override
    void execute(State state) {
        // TODO
    }
}

class MemoryStore extends Operator {
    @Override
    void execute(State state) {
        // TODO
    }
}

class MemoryRecall extends Operator {
    @Override
    void execute(State state) {
        // TODO
    }
}

