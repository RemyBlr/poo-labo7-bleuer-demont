package calculator;

/**
 * Memory Store operator (MS) – store the current value in memory
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class MemoryStore extends Operator {
    /**
     * Executes the "Memory Store" operation by storing the current value
     * in the calculator's state into the memory.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        if (state.isError()) {
            return;
        }

        state.setMemory(state.getCurrentValue());
    }
}
