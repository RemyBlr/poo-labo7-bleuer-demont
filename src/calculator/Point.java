package calculator;

/**
 * Point operator (.) – add a point to the current value
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Point extends Operator {
    /**
     * Executes the point operation on the given state.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        if (!state.isError() &&
            !state.getCurrentValue().contains(".") &&
            !Double.isInfinite(Double.parseDouble(state.getCurrentValue()))) {

            state.setCurrentValue(state.getCurrentValue() + ".");
        }
        state.setOperationPerformed(false);
    }
}