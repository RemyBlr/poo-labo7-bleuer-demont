package calculator;

/**
 * Opposite operator (+/-) – opposite the current value
 * Use the unaryOperation method from Operator class
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Opposite extends Operator {
    /**
     * Executes the opposite operation on the given state.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        if(!state.getCurrentValue().equals("0")) {
            unaryOperation(state, operand -> -operand);
        }
        state.setOperationPerformed(false);
    }
}
