package algorithms.part.one._3_stack;

// Custom exception which suggests that the Stack is empty.
public class EmptyStackException extends RuntimeException {

    public EmptyStackException() {
        super("No element present in stack.Stack");
    }

    public EmptyStackException(String message) {
        super(message);
    }

}
