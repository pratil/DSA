package sort;

public class NotSortedException extends RuntimeException {
    public NotSortedException() {
        super("Array is not sorted");
    }

    public NotSortedException(Order order) {
        super("Array is not sorted in " + order + " order");
    }
}
