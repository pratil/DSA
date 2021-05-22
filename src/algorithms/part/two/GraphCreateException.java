package algorithms.part.two;

public class GraphCreateException extends RuntimeException {
    public GraphCreateException() {
        super("Error creating graph");
    }

    public GraphCreateException(String message) {
        super(message);
    }

    public GraphCreateException(Throwable cause) {
        super(cause);
    }
}
