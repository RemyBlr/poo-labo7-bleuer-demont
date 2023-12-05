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
            return;
        }

        if (!state.getMemory().equals("0"))
            state.setCurrentValue(state.getMemory());
    }
}
