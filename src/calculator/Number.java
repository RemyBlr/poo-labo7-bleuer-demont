package calculator;

/**
 * Number operator - add a digit to the current value
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Number extends Operator {
    private String value;

    public Number(String value) {
        this.value = value;
    }

    @Override
    void execute(State state) {
        if (state.isError()) {
            return; // Ne pas effectuer l'opération si une erreur est déjà présente
        }

        if (state.isOperationPerformed()) {
            state.getStack().push(state.getCurrentValue());
            state.setCurrentValue("0");
            state.setOperationPerformed(false);
        }

        if (state.getCurrentValue().equals("0"))
            state.setCurrentValue(value);
        else
            state.setCurrentValue(state.getCurrentValue() + value);
    }
}
