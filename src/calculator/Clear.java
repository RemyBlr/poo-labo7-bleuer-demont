package calculator;

/**
 * Clear operator (C) – clear the stack and the current value
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Clear extends Operator {
    /**
     * Executes the Clear operation by clearing the stack and setting the
     * current value to "0".
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        state.clear();
    }
}
