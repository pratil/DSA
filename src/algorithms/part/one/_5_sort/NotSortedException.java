package algorithms.part.one._5_sort;

//An exception which is raised when array is not sorted
public class NotSortedException extends RuntimeException {
    public NotSortedException() {
        super("Elements are not sorted");
    }

    public NotSortedException(Order order) {
        super("Elements are not sorted in " + order + " order");
    }
}
