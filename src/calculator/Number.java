package calculator;

/**
 * Number operator - add a digit to the current value
 * Can't be used if an operation has been performed
 * Can't be used if an error is present
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Number extends Operator {
    private final String value;

    public Number(String value) {
        this.value = value;
    }

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
