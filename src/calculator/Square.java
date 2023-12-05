package calculator;

/**
 * Square operator (x^2) – square the current value
 * Use the unaryOperation method from Operator class
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Square extends Operator {
    /**
     * Executes the square operation on the given state.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        unaryOperation(state, operand -> operand * operand);
    }
}
