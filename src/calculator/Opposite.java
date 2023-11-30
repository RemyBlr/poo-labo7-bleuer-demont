package calculator;

/**
 * Opposite operator (+/-) - opposite the current value
 * Use the unaryOperation method from Operator class
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Opposite extends Operator {
    @Override
    void execute(State state) {
        unaryOperation(state, operand -> -operand);
    }
}
