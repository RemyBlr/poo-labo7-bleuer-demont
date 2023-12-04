package calculator;

/**
 * Point operator (.) - add a point to the current value
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Point extends Operator {
    @Override
    void execute(State state) {
        if (!state.isError() && !state.getCurrentValue().contains(".")) {
            state.setCurrentValue(state.getCurrentValue() + ".");
        }
        state.setOperationPerformed(false);
    }
}
