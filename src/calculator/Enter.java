package calculator;

/**
 * Enter operator (ent) - push the current value to the top of the stack
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Enter extends Operator {
    @Override
    void execute(State state) {
        if (state.isError() ||
            Double.isInfinite(Double.parseDouble(state.getCurrentValue())) ||
            state.getCurrentValue().equals("0")) {

            return;
        }

        String currentValue = state.getCurrentValue();

        if (!currentValue.equals("0")) {
            if (currentValue.endsWith(".")) {
                state.getStack().push(currentValue + "0");
            } else if (!currentValue.contains(".")) {
                state.getStack().push(currentValue + ".0");
            } else {
                state.getStack().push(currentValue);
            }
        }

        state.setCurrentValue("0");
        state.setOperationPerformed(false);
    }
}
