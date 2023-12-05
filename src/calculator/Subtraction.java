package calculator;

/**
 * Subtraction operator (-) – subtract the top of the stack by the current value
 * Use the binaryOperation method from Operator class
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Subtraction extends Operator {
    /**
     * Executes the subtraction operation on the given state.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        binaryOperation(state, (operand1, operand2) -> operand1 - operand2);
    }
}
