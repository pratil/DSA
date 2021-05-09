package algorithms.part.one._4_queue;

// Custom exception which suggests that the Queue is empty.
public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("No element present in queue.Queue");
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}
