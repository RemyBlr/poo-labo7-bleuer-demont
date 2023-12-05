package calculator;

/**
 * Division operator (/) – divide the top of the stack by the current value
 * Use the binaryOperation method from Operator class
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Division extends Operator {
    /**
     * Executes the Division operation by dividing the top of the stack by the
     * current value.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        binaryOperation(state, (operand1, operand2) -> operand2 / operand1);
    }
}
