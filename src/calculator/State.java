package calculator;

import util.Stack;

public class State {
    private double currentValue;
    private Stack<Double> stack;
    private boolean isError;

    // Constructeur, getters, setters, etc.
    public State(){
        this.currentValue = 0;
        this.stack = new Stack<>();
        this.isError = false;
    }

    public State(double currentValue, Stack<Double> stack){
        this.currentValue = currentValue;
        this.stack = stack;
        this.isError = false;
    }

    double getCurrentValue(){
        return currentValue;
    }

    void setCurrentValue(double currentValue){
        this.currentValue = currentValue;
    }


    public Stack<Double> getStack() {
        return stack;
    }

    public void setStack(Stack<Double> stack) {
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
    }
}
