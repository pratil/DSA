package _2_bag;

// Custom exception which suggests that the bag is empty.
public class EmptyBagException extends RuntimeException {
    public EmptyBagException() {
        super("No element present in Bag");
    }

    public EmptyBagException(String message) {
        super(message);
    }
}
