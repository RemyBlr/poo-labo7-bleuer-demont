package calculator;

/**
 * Point operator (.) - add a point to the current value
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class Point extends Operator {
    @Override
    void execute(State state) {
        if (state.isError()) {
            return; // Ne pas effectuer l'opération si une erreur est déjà présente
        }

        if (state.getCurrentValue().contains("."))
            return;

        String currentValStr = String.valueOf(state.getCurrentValue());
        String concat = currentValStr + ".";

        state.setCurrentValue(concat);
    }
}
