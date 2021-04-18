package _3_stack;

public class EmptyStackException extends RuntimeException {

    public EmptyStackException() {
        super("No element present in stack.Stack");
    }

    public EmptyStackException(String message) {
        super(message);
    }

}
