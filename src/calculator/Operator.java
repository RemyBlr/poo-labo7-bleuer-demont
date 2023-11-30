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
        if (state.isError()) {
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
        state.setCurrentValue(String.valueOf(result));
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
        binaryOperation(state, (operand1, operand2) -> operand2 / operand1);
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

class SquareRoot extends Operator {
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
    private String value;

    public Number(String value) {
        this.value = value;
    }

    @Override
    void execute(State state) {
        if (state.isError()) {
            return; // Ne pas effectuer l'opération si une erreur est déjà présente
        }

        if (state.isOperationPerformed()) {
            state.getStack().push(state.getCurrentValue());
            state.setCurrentValue("0");
            state.setOperationPerformed(false);
        }

        if (state.getCurrentValue().equals("0"))
            state.setCurrentValue(value);
        else
            state.setCurrentValue(state.getCurrentValue() + value);
    }
}

// ------------------ Clear ------------------
class ClearEntry extends Operator {
    @Override
    void execute(State state) {
        state.setError(false);
        state.setCurrentValue("0");
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
        if (state.isError()) {
            return; // Ne pas effectuer l'opération si une erreur est déjà présente
        }

        state.setMemory(state.getCurrentValue());
    }
}

class MemoryRecall extends Operator {
    @Override
    void execute(State state) {
        if (state.isError()) {
            return; // Ne pas effectuer l'opération si une erreur est déjà présente
        }

        if (state.getMemory() != "0") // je sais pas si besoin, si envie de stocker 0 pourquoi pas
            state.setCurrentValue(state.getMemory());
    }
}

// ------------------ Misc ------------------
class Enter extends Operator {
    @Override
    void execute(State state) {
        if (state.isError()) {
            return;
        }

        if (state.getCurrentValue() == "0")
            return;

        state.getStack().push(state.getCurrentValue());
        state.setCurrentValue("0");
        state.setOperationPerformed(false);
    }
}

class Point extends Operator {
    @Override
    void execute(State state) {
        if (state.isError()) {
            return; // Ne pas effectuer l'opération si une erreur est déjà présente
        }

        if (state.getCurrentValue().contains("."))
            return;

        String currentValStr = String.valueOf(state.getCurrentValue());
        String concat = currentValStr + ".";

        state.setCurrentValue(concat);
    }
}

class Backspace extends Operator {
    @Override
    void execute(State state) {
        String currentValStr = state.getCurrentValue();
        if (currentValStr.length() == 1) {
            state.setCurrentValue("0");
        } else {
            currentValStr = currentValStr.substring(0, currentValStr.length() - 1);
            state.setCurrentValue(currentValStr);
        }
    }
}