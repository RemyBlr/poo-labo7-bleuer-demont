package calculator;

/**
 * Memory Recall operator (MR) - recall the value stored in memory to the current value
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class MemoryRecall extends Operator {
    @Override
    void execute(State state) {
        if (state.isError()) {
            return; // Ne pas effectuer l'opération si une erreur est déjà présente
        }

        if (state.getMemory() != "0") // je sais pas si besoin, si envie de stocker 0 pourquoi pas
            state.setCurrentValue(state.getMemory());
    }
}
