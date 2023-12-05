package calculator;

/**
 * Clear Entry operator (CE) – clear the current value
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class ClearEntry extends Operator {
    /**
     * Executes the Clear Entry operation by setting the current value to "0"
     * and clearing any error state.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        state.setError(false);
        state.setCurrentValue("0");
    }
}
