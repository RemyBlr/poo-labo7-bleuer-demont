package calculator;

import util.Stack;


/**
 * State of the calculator
 * Contains the current value, the stack, the memory and the error state
 * The error state is set to true if an error occurs (division by zero, etc.)
 * The memory is used to store a value (M+, M-, MR, MC)
 * The stack is used to store the values of the operations
 * The current value is the value displayed on the calculator
 *
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

    /**
     * Default constructor initializes the state with default values.
     */
    public State(){
        this.currentValue = "0";
        this.stack = new Stack<>();
        this.isError = false;
        this.memory = "0";
    }

    /**
     * Constructor that allows initializing the state with specific values.
     *
     * @param currentValue The initial current value.
     * @param stack        The initial stack.
     */
    public State(String currentValue, Stack<String> stack){
        this.currentValue = currentValue;
        this.stack = stack;
        this.isError = false;
    }

    /**
     * Get the current value.
     *
     * @return The current value.
     */
    public String getCurrentValue(){
        return currentValue;
    }

    /**
     * Set the current value.
     *
     * @param currentValue The new current value.
     */
    protected void setCurrentValue(String currentValue){
        this.currentValue = currentValue;
    }

    /**
     * Get the memory value.
     *
     * @return The memory value.
     */
    public String getMemory() {
        return memory;
    }

    /**
     * Set the memory value.
     *
     * @param memory The new memory value.
     */
    protected void setMemory(String memory) {
        this.memory = memory;
    }

    /**
     * Check if an operation has been performed.
     *
     * @return True if an operation has been performed, false otherwise.
     */
    public boolean isOperationPerformed() {
        return isOperationPerformed;
    }

    /**
     * Set the operation performed status.
     *
     * @param isOperationPerformed The new operation performed status.
     */
    protected void setOperationPerformed(boolean isOperationPerformed) {
        this.isOperationPerformed = isOperationPerformed;
    }

    /**
     * Get the stack.
     *
     * @return The stack.
     */
    public Stack<String> getStack() {
        return stack;
    }

    /**
     * Set the stack.
     *
     * @param stack The new stack.
     */
    protected void setStack(Stack<String> stack) {
        this.stack = stack;
    }

    /**
     * Check if an error has occurred.
     *
     * @return True if an error has occurred, false otherwise.
     */
    public boolean isError() {
        return isError;
    }

    /**
     * Set the error status.
     *
     * @param isError The new error status.
     */
    protected void setError(boolean isError) {
        this.isError = isError;
    }

    /**
     * Clears the calculator state, resetting values to default.
     */
    public void clear() {
        this.currentValue = "0";
        this.stack.clear();
        this.isError = false;
    }
}
