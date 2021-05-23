# Sorting

> **Different algorithms using which I have implemented Sorting of generic objects:**    
> 👉 [Selection Sort](./methods/Selection.java)  
> 👉 [Insertion Sort](./methods/Insertion.java)  
> 👉 [Heap Sort](./methods/Heap.java)  
> 👉 [Merge Sort](./methods/Merge.java)  
> 👉 [Quick Sort](./methods/Quick.java)

The basic layout for all the union find algorithms is similar:

- A function to Sort the generic array of objects in Ascending Order
- A function to Sort the generic array of objects in Descending Order

Also, some other Classes an Interface, and an Enum to help create sorting methods

- [Order](Order.java) - An enum to define the order in which we have to sort the array
- [Sort](Sort.java) - An interface, Generic Sort parent for all the sorting algorithms
- [Shuffle](Shuffle.java) - A class to shuffle the list of generic array of objects
- [NotSortedException](NotSortedException.java) - An exception which is raised when array is not sorted
- [StopWatch](StopWatch.java) - A class to calculate the time difference between a block/line of code

_**Sort**: A class to calculate the time difference between a block/line of code_

```java
// java interface
package algorithms.part.one._5_sort;

// Generic Sort parent for all the sorting algorithms
public interface Sort<P extends Comparable<P>> {

    String getName(); // to get the name of the sort method only for output purpose

    void sortAscending(P[] array); // a method to sort the array in Ascending order

    void sortDescending(P[] array); // a method to sort the array in Descending order

    // a method to compare two numbers with the given index in the array
    default int compare(P[] array, int first, int second) { /* code here */ }

    // a method to check if the first index is less than second index in the array
    default boolean isLess(P[] array, int first, int second) { /* code here */ }

    // a method to check if the first index is greater than second index in the array
    default boolean isGreater(P[] array, int first, int second) { /* code here */ }

    // a method to compare two numbers
    default int compare(P first, P second) { /* code here */ }

    // a method to check if the first element is less than second element
    default boolean isLess(P first, P second) { /* code here */ }

    // a method to check if the first element is greater than second element
    default boolean isGreater(P first, P second) { /* code here */ }

    // a method to swap two positions in the given array
    default void swap(P[] array, int first, int second) { /* code here */ }

    // a generic method to sort the array in the given order as passed in parameters
    default void sort(P[] array, Order order) { /* code here */ }

    // a default method to sort the array in ascending order if no order is passed
    default void sort(P[] array) { /* code here */ }

    // a function to validate if the given array is sorted in the given order or not, and return true if sorted
    default boolean isSorted(P[] array, Order order) { /* code here */ }

    // a function to assert that the array is sorted in the given order if not sorted would raise an exception
    default void assertSorted(P[] array, Order order) throws NotSortedException { /* code here */ }
}
```
