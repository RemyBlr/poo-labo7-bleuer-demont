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
        if (state.isError() || state.getCurrentValue().equals("0")) {
            return;
        }

        String currentValue = state.getCurrentValue();

        double parsedValue = Double.parseDouble(currentValue);

        if (Double.isInfinite(parsedValue)) {
            state.getStack().push(currentValue);
        } else {
            String formattedValue = currentValue.endsWith(".") ? currentValue + "0" : currentValue;
            formattedValue = !formattedValue.contains(".") ? formattedValue + ".0" : formattedValue;
            state.getStack().push(formattedValue);
        }

        state.setCurrentValue("0");
        state.setOperationPerformed(false);
    }
}
