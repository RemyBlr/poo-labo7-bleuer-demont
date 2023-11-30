package calculator;

/**
 * Addition operator (+) - add the current value to the top of the stack
 * Use the binaryOperation method from Operator class
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Addition extends Operator {
    @Override
    void execute(State state) {
        binaryOperation(state, (operand1, operand2) -> operand1 + operand2);
    }
}
