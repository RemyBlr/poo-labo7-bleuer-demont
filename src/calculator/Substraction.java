package calculator;

/**
 * Substraction operator (-) - substract the top of the stack by the current value
 * Use the binaryOperation method from Operator class
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Substraction extends Operator {
    @Override
    void execute(State state) {
        binaryOperation(state, (operand1, operand2) -> operand1 - operand2);
    }
}
