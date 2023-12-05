package calculator;

/**
 * Backspace operator (<=) – delete the last digit of the current value
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Backspace extends Operator {
    /**
     * Executes the Backspace operation by deleting the last digit of the current value.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        String currentValStr = state.getCurrentValue();
        if (currentValStr.length() == 1 || Double.isInfinite(Double.parseDouble(currentValStr))) {
            state.setCurrentValue("0");
        } else {
            currentValStr = currentValStr.substring(0, currentValStr.length() - 1);
            state.setCurrentValue(currentValStr);
        }
    }
}
