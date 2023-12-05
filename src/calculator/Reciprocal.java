package calculator;

/**
 * Reciprocal operator (1/x) – reciprocal the current value
 * Use the unaryOperation method from Operator class
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Reciprocal extends Operator {
    /**
     * Executes the reciprocal operation on the given state.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        unaryOperation(state, operand -> 1 / operand);
    }
}
