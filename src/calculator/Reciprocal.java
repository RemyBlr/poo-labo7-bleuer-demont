package calculator;

/**
 * Reciprocal operator (1/x) - reciprocal the current value
 * Use the unaryOperation method from Operator class
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Reciprocal extends Operator {
    @Override
    void execute(State state) {
        unaryOperation(state, operand -> 1 / operand);
    }
}
