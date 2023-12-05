package calculator;

/**
 * Number operator – add a digit to the current value
 * Can't be used if an operation has been performed
 * Can't be used if an error is present
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Number extends Operator {
    private final String value;

    /**
     * Constructs a Number operator with the specified digit value.
     *
     * @param value The digit value represented by this Number operator.
     */
    public Number(String value) {
        this.value = value;
    }

    /**
     * Executes the Number operation by adding the specified digit to the current value.
     * The Number operator can't be used if an operation has been performed or if an error is present.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        if (!state.isError()) {
            if (state.isOperationPerformed()) {
                state.getStack().push(state.getCurrentValue());
                state.setCurrentValue("0");
                state.setOperationPerformed(false);
            }
        }

        if (state.getCurrentValue().equals("0"))
            state.setCurrentValue(value);
        else
            state.setCurrentValue(state.getCurrentValue() + value);
    }
}
