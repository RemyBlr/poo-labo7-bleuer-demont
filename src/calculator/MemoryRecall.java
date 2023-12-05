package calculator;

/**
 * Memory Recall operator (MR) – recall the value stored in memory to the current value
 *
 * @author Rémy Bleuer
 * @author Kilian Demont
 * @see Operator
 */
class MemoryRecall extends Operator {
    /**
     * Executes the "Memory Recall" operation by setting the current value
     * to the value stored in memory in the provided calculator state.
     *
     * @param state The current state of the calculator.
     */
    @Override
    void execute(State state) {
        if (state.isError()) {
            return;
        }

        if (!state.getMemory().equals("0"))
            state.setCurrentValue(state.getMemory());
    }
}
