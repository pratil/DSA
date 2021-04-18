package _2_bag;

public class EmptyBagException extends RuntimeException {
    public EmptyBagException() {
        super("No element present in Bag");
    }

    public EmptyBagException(String message) {
        super(message);
    }
}
