package calculator;

/**
 * Square operator (x^2) - square the current value
 * Use the unaryOperation method from Operator class
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Square extends Operator {
    @Override
    void execute(State state) {
        unaryOperation(state, operand -> operand * operand);
    }
}
