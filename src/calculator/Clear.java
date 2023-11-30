package calculator;

/**
 * Clear operator (C) - clear the stack and the current value
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Clear extends Operator {
    @Override
    void execute(State state) {
        state.clear();
    }
}
