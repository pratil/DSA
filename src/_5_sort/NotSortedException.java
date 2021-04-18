package _5_sort;

public class NotSortedException extends RuntimeException {
    public NotSortedException() {
        super("Elements are not sorted");
    }

    public NotSortedException(Order order) {
        super("Elements are not sorted in " + order + " order");
    }
}
