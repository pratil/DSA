package algorithms.part.two;

public class FullGraphNotCoveredException extends RuntimeException {
    public FullGraphNotCoveredException() {
        super("All the vertices not covered of the graph");
    }

    public FullGraphNotCoveredException(String message) {
        super(message);
    }
}
