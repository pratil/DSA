# Heap Tree / Priority Queue

> Heap is a special Tree-based data structure in which the tree is a complete binary tree.  
> Generally, Heaps can be of two types:  
> 👉 Max-Heap:  
> In a Max-Heap the key present at the root node must be greatest among the keys present at all of its children.  
> The same property must be recursively true for all sub-trees in that Binary Tree.  
> 👉 Min-Heap:  
> In a Min-Heap the key present at the root node must be minimum among the keys present at all of its children.  
> The same property must be recursively true for all sub-trees in that Binary Tree.

_The skeleton to implement any union find algorithm_

```java
// Generic Binary Heap Tree parent for both min and max heap algorithms
public interface BinaryHeapTree<P extends Comparable<P>> {

    // to swap two positions in the list
    default void swap(List<P> array, int first, int second) { /* code here */ }

    // to compare positions in the list
    default int compare(List<P> array, int first, int second) { /* code here */ }

    // function to swim an index from a heap position to it's upper positions if required
    // i.e. if it is greater/less than it's child it should be moved up recursively in a min/max heap
    void swim(int index);

    // function to sink an index from a heap position to it's lower positions if required
    // i.e. if it is less/greater than it's child it should be moved down recursively in a min/max heap
    void sink(int index);

    // to get the root of the tree i.e. the top of the tree
    P peek();

    // to insert a new element in the tree
    P insert(P element);

    // to delete an element from the tree
    P delete();

    // to get the size of the tree
    int size();

    // to check if the tree is empty or not
    default boolean isEmpty() { /* code here */ }
}
```