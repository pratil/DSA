package _4_queue;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("No element present in queue.Queue");
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}
