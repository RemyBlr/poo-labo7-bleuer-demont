package calculator;

/**
 * Memory Store operator (MS) - store the current value in memory
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class MemoryStore extends Operator {
    @Override
    void execute(State state) {
        if (state.isError()) {
            return; // Ne pas effectuer l'opération si une erreur est déjà présente
        }

        state.setMemory(state.getCurrentValue());
    }
}
