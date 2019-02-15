package consoleappmaven.structures.stack;

public interface Stack {

    /**
     * Push element into stack top.
     *
     * @param element that we need to push
     * @return stack top index
     */
    int push(int element);

    /**
     * Delete top stack element.
     *
     * @return deleted stack element
     */
    int pop();

}
