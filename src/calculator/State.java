package calculator;

import util.Stack;


/**
 * State of the calculator
 * Contains the current value, the stack, the memory and the error state
 * The error state is set to true if an error occurs (division by zero, etc.)
 * The memory is used to store a value (M+, M-, MR, MC)
 * The stack is used to store the values of the operations
 * The current value is the value displayed on the calculator
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Stack
 */
public class State {
    private String currentValue;
    private Stack<String> stack;
    private boolean isError;
    private String memory;
    private boolean isOperationPerformed;

    // Constructeur, getters, setters, etc.
    public State(){
        this.currentValue = "0";
        this.stack = new Stack<>();
        this.isError = false;
        this.memory = "0";
    }

    public State(String currentValue, Stack<String> stack){
        this.currentValue = currentValue;
        this.stack = stack;
        this.isError = false;
    }

    String getCurrentValue(){
        return currentValue;
    }

    void setCurrentValue(String currentValue){
        this.currentValue = currentValue;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public boolean isOperationPerformed() {
        return isOperationPerformed;
    }

    public void setOperationPerformed(boolean operationPerformed) {
        this.isOperationPerformed = operationPerformed;
    }

    public Stack<String> getStack() {
        return stack;
    }

    public void setStack(Stack<String> stack) {
        this.stack = stack;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

    public void clear() {
        // Logique pour réinitialiser l'état
        this.currentValue = "0";
        this.stack.clear();
        this.isError = false;
    }
}
