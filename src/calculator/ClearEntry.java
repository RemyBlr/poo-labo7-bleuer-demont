package calculator;

/**
 * Clear Entry operator (CE) - clear the current value
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class ClearEntry extends Operator {
    @Override
    void execute(State state) {
        state.setError(false);
        state.setCurrentValue("0");
    }
}
