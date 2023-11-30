package calculator;

/**
 * Square Root operator (sqrt) - square root the current value
 * Use the unaryOperation method from Operator class
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class SquareRoot extends Operator {
    @Override
    void execute(State state) {
        unaryOperation(state, Math::sqrt);
    }
}
