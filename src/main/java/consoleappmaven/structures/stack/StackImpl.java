package consoleappmaven.structures.stack;

/**
 * @author atsikhamirau on 12.02.2019
 */
public class StackImpl implements Stack {

    private static final int DEFAULT_STACK_SIZE = 10;

    private int[] stack = new int[DEFAULT_STACK_SIZE];

    /**
     * Point to first empty stack cell.
     */
    private int top;

    public StackImpl() {
    }

    public StackImpl(int size) {
        stack = new int[size];
    }

    @Override
    public int push(int element) {
        if (isStackOverflow()) {
            System.out.println("Trying to push [" + element + "] but stack Overflow! Top element = [" + stack[top - 1] + "]");
            return -1;
        }

        stack[top] = element;
        System.out.println("Pushed: " + stack[top]);
        printStack();
        top++;

        return top;
    }

    @Override
    public int pop() {
        if (isStackOverflow()) {
            top = stack.length - 1;
        }
        if (isStackEmpty()) {
            System.out.print("Stack is empty: ");
            printStack();
            return top = 0;
        }

        int element = stack[top];
        System.out.println("Popped: " + element);
        stack[top] = 0;
        printStack();
        top--;

        return element;
    }

    private boolean isStackOverflow() {
        return top > stack.length - 1;
    }

    private void printStack() {
        for (int element : stack) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private boolean isStackEmpty() {
        return top == -1 || (top == 0 && stack[top] == 0);
    }

}
