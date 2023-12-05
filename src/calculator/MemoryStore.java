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
            return;
        }

        state.setMemory(state.getCurrentValue());
    }
}
