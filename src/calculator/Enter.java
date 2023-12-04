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
        if (!state.isError() && !state.getCurrentValue().equals("0")) {
            state.getStack().push(state.getCurrentValue());

            state.setCurrentValue("0");
            state.setOperationPerformed(false);
        }
    }
}
