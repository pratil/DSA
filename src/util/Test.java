package util;

import algorithms.part.one._1_unionfind.*;
import algorithms.part.one._2_bag.Bag;
import algorithms.part.one._3_stack.Stack;
import algorithms.part.one._4_queue.Queue;
import algorithms.part.one._5_sort.*;
import algorithms.part.one._6_binaryheap.MaxHeapTree;
import algorithms.part.one._6_binaryheap.MinHeapTree;
import algorithms.part.one._7_symboltable.ordered.BST;
import algorithms.part.one._7_symboltable.ordered.RedBlackBST;
import algorithms.part.one._7_symboltable.unordered.LinearProbing;
import algorithms.part.one._7_symboltable.unordered.SeparateChaining;

import java.util.Arrays;

// a class to test all different algorithms and methods
public class Test {

    // function to test all the Union Find Algorithms that are children of UnionFind
    public static void unionFind(UnionFind unionFind, int countOfNodes, int unionCount, int findCount) {
        int first, second;
        System.out.println(unionFind);
        for (int i = 0; i < unionCount; i++) {
            first = Random.intValue(countOfNodes);
            second = Random.intValue(countOfNodes);
            unionFind.union(first, second);
            System.out.println("union(" + first + ", " + second + ")");
            System.out.println(unionFind);
        }
        System.out.println(unionFind);
        for (int i = 0; i < findCount; i++) {
            first = Random.intValue(countOfNodes);
            second = Random.intValue(countOfNodes);
            System.out.println("find(" + first + ", " + second + "): " + unionFind.find(first, second));
        }
    }

    public static void unionFind(UnionFind unionFind, int countOfNodes) {
        unionFind(unionFind, countOfNodes, 5, 4);
    }

    // function to test QuickFind
    public static void quickFind() {
        int length = 10;
        unionFind(new QuickFind(length), length);
    }

    // function to test QuickUnion
    public static void quickUnion() {
        int length = 10;
        unionFind(new QuickUnion(length), length);
    }

    // function to test WeightedQuickUnion
    public static void weightedQuickUnion() {
        int length = 10;
        unionFind(new WeightedQuickUnion(length), length);
    }

    // function to test QuickUnionWithPathCompression
    public static void quickUnionWithPathCompression() {
        int length = 10;
        unionFind(new QuickUnionWithPathCompression(length), length);
    }

    // function to test Bag Data Structure, Bag of students
    public static void studentBag() {
        Bag<Student> studentBag = new Bag<>();
        System.out.println(studentBag);
        System.out.println("studentBag.isEmpty()=> " + studentBag.isEmpty());
        for (int i = 0; i < 10; i++)
            studentBag.add(Student.getRandomStudentData());
        System.out.println("studentBag.isEmpty()=> " + studentBag.isEmpty());
        System.out.println(studentBag);
    }

    // function to test Stack Data Structure, Stack of students
    public static void studentStack() {
        Stack<Student> studentStack = new Stack<>();
        System.out.println(studentStack);
        for (int i = 0; i < 10; i++)
            studentStack.push(Student.getRandomStudentData());
        System.out.println(studentStack);
        System.out.println("studentStack.peek()=> " + studentStack.peek());
        System.out.println("studentStack.pop()=> " + studentStack.pop());
        System.out.println("studentStack.size()=> " + studentStack.size());
        System.out.println("studentStack.isEmpty()=> " + studentStack.isEmpty());
    }

    // function to test Queue Data Structure, Queue of students
    public static void studentQueue() {
        Queue<Student> studentQueue = new Queue<>();
        System.out.println(studentQueue);
        for (int i = 0; i < 10; i++)
            studentQueue.add(Student.getRandomStudentData());
        System.out.println(studentQueue);
        System.out.println("studentQueue.size()=> " + studentQueue.size());
        System.out.println("studentQueue.peek()=> " + studentQueue.peek());
        System.out.println("studentQueue.poll()=> " + studentQueue.poll());
        System.out.println("studentQueue.element()=> " + studentQueue.element());
        System.out.println("studentQueue.remove()=> " + studentQueue.remove());
        System.out.println("studentQueue.peek()=> " + studentQueue.peek());
        System.out.println("studentQueue.size()=> " + studentQueue.size());
        System.out.println("studentQueue.isEmpty()=> " + studentQueue.isEmpty());
    }

    // function to test Sorting using all the methods which are children of Sort, Sorting of student array
    private static void studentSort(Sort<Student> method, int length) {
        Order order;
        Student[] students = new Student[length];
        for (int i = 0; i < length; i++)
            students[i] = Student.getRandomStudentData();
        System.out.println("Student array before sorting");
        Student.printArray(students);
        order = Order.Ascending;
        method.sort(students, order);
        System.out.println("Student array after sorting in " + order + " order");
        Student.printArray(students);
        order = Order.Descending;
        method.sort(students, order);
        System.out.println("Student array after sorting in " + order + " order");
        Student.printArray(students);
    }

    private static void studentSort(Sort<Student> method) {
        studentSort(method, 10);
    }

    // function to test SelectionSort
    public static void studentSelectionSort() {
        Sort<Student> selection = new Selection<>();
        studentSort(selection);
    }

    // function to test InsertionSort
    public static void studentInsertionSort() {
        Sort<Student> insertion = new Insertion<>();
        studentSort(insertion);
    }

    // function to test Shuffle an integer array
    public static void integerShuffle() {
        Shuffle<Integer> shuffle = new Shuffle<>();
        int length = 10;
        Integer[] integers = new Integer[length];
        for (int i = 0; i < length; i++)
            integers[i] = i;
        System.out.println(Arrays.toString(integers));
        shuffle.getRandomisedArray(integers);
        System.out.println(Arrays.toString(integers));
    }

    // function to test MergeSort
    public static void studentMergeSort() {
        Sort<Student> merge = new Merge<>();
        studentSort(merge);
    }

    // function to test HeapSort
    public static void studentHeapSort() {
        Sort<Student> heap = new Heap<>();
        studentSort(heap);
    }

    // function to test QuickSort
    public static void studentQuickSort() {
        Sort<Student> quick = new Quick<>();
        studentSort(quick, 1000);
    }

    // function to test MaxHeapTree, a heap tree of students
    public static void studentMaxHeapTree() {
        MaxHeapTree<Student> maxHeapTree = new MaxHeapTree<>();
        int length = 10;
        System.out.println(maxHeapTree);
        for (int i = 0; i < length; i++)
            System.out.println(maxHeapTree.insert(Student.getRandomStudentData()));
        System.out.println(maxHeapTree);
        for (int i = 0; i < length; i++)
            System.out.println("size: " + maxHeapTree.size() + " data: " + maxHeapTree.delete());
        System.out.println(maxHeapTree);
    }

    // function to test MinHeapTree, a heap tree of students
    public static void studentMinHeapTree() {
        MinHeapTree<Student> minHeapTree = new MinHeapTree<>();
        int length = 10;
        System.out.println(minHeapTree);
        for (int i = 0; i < length; i++)
            System.out.println(minHeapTree.insert(Student.getRandomStudentData()));
        System.out.println(minHeapTree);
        for (int i = 0; i < length; i++)
            System.out.println("size: " + minHeapTree.size() + " data: " + minHeapTree.delete());
        System.out.println(minHeapTree);
    }

    // function to test Binary Search Tree (BST) of students
    public static void studentBST() {
        int length = 10;
        BST<Integer, Student> studentBST = new BST<>();
        Iterable<Integer> iterable = studentBST.keys();
        System.out.println("Items before insertion: " + iterable);
        System.out.println("------------------------------------------------------------------------------");
        Student student;
        for (int i = 0; i < length; i++) {
            student = Student.getRandomStudentData();
            System.out.println("Inserting: " + student);
            studentBST.put(student.roll, student);
        }
        System.out.println("------------------------------------------------------------------------------");
        iterable = studentBST.keys();
        System.out.println("Items after insertion: " + iterable);
        studentBST.printSizeLeftAndRightSubtrees();
        int minimumKey = studentBST.getMinimum();
        System.out.println("BST containsKey(" + minimumKey + "): -> " + studentBST.containsKey(minimumKey));
        System.out.println("BST minimum key: -> " + minimumKey + " value -> " + studentBST.get(minimumKey));
        System.out.println("BST rank of minimum key: -> " + studentBST.rank(minimumKey));
        System.out.println("BST floor value of minimum key - 1 : -> " + studentBST.floor(minimumKey - 1));
        System.out.println("BST ceil value of minimum key + 1 : -> " + studentBST.ceil(minimumKey + 1));
        int maximumKey = studentBST.getMaximum();
        System.out.println("BST containsKey(" + maximumKey + "): -> " + studentBST.containsKey(maximumKey));
        System.out.println("BST maximum key: -> " + maximumKey + " value -> " + studentBST.get(maximumKey));
        System.out.println("BST rank of maximum key: -> " + studentBST.rank(maximumKey));
        System.out.println("BST floor value of maximum key - 1 : -> " + studentBST.floor(maximumKey - 1));
        System.out.println("BST ceil value of maximum key + 1 : -> " + studentBST.ceil(maximumKey + 1));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Delete minimum key: " + studentBST.delete(minimumKey));
        minimumKey = studentBST.getMinimum();
        iterable = studentBST.keys();
        System.out.println("Items after deletion: " + iterable);
        studentBST.printSizeLeftAndRightSubtrees();
        System.out.println("BST containsKey(" + minimumKey + "): -> " + studentBST.containsKey(minimumKey));
        System.out.println("BST minimum key: -> " + minimumKey + " value -> " + studentBST.get(minimumKey));
        System.out.println("BST rank of minimum key: -> " + studentBST.rank(minimumKey));
        System.out.println("BST floor value of minimum key - 1 : -> " + studentBST.floor(minimumKey - 1));
        System.out.println("BST ceil value of minimum key + 1 : -> " + studentBST.ceil(minimumKey + 1));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Delete maximum key: " + studentBST.delete(maximumKey));
        maximumKey = studentBST.getMaximum();
        iterable = studentBST.keys();
        System.out.println("Items after deletion: " + iterable);
        studentBST.printSizeLeftAndRightSubtrees();
        System.out.println("BST containsKey(" + maximumKey + "): -> " + studentBST.containsKey(maximumKey));
        System.out.println("BST maximum key: -> " + maximumKey + " value -> " + studentBST.get(maximumKey));
        System.out.println("BST rank of maximum key: -> " + studentBST.rank(maximumKey));
        System.out.println("BST floor value of maximum key - 1 : -> " + studentBST.floor(maximumKey - 1));
        System.out.println("BST ceil value of maximum key + 1 : -> " + studentBST.ceil(maximumKey + 1));
        System.out.println("------------------------------------------------------------------------------");
        int start = 1390;
        int end = 1550;
        student = Student.getRandomStudentData();
        student.roll = end;
        studentBST.put(student.roll, student);
        student.roll = start;
        studentBST.put(student.roll, student);
        System.out.println("BST all keys: " + studentBST.keys());
        System.out.println("BST count of all keys between (" + start + ", " + end + "): " + studentBST.countKeys(start, end));
        System.out.println("BST all keys between (" + start + ", " + end + "): " + studentBST.keys(start, end));
    }

    // function to test Red Black BST of students
    public static void studentRedBlackBST() {
        int length = 10;
        RedBlackBST<Integer, Student> studentRedBlackBST = new RedBlackBST<>();
        Iterable<Integer> iterable = studentRedBlackBST.keys();
        System.out.println("Items before insertion: " + iterable);
        System.out.println("------------------------------------------------------------------------------");
        Student student;
        for (int i = 0; i < length - 1; i++) {
            student = Student.getRandomStudentData();
            System.out.println("Inserting: " + student);
            studentRedBlackBST.put(student.roll, student);
        }
        student = studentRedBlackBST.get(studentRedBlackBST.getMaximum());
        studentRedBlackBST.put(student.roll, student);
        System.out.println("------------------------------------------------------------------------------");
        iterable = studentRedBlackBST.keys();
        System.out.println("Items after insertion: " + iterable);
        studentRedBlackBST.printSizeLeftAndRightSubtrees();
        int minimumKey = studentRedBlackBST.getMinimum();
        System.out.println("RedBlackBST containsKey(" + minimumKey + "): -> " + studentRedBlackBST.containsKey(minimumKey));
        System.out.println("RedBlackBST minimum key: -> " + minimumKey + " value -> " + studentRedBlackBST.get(minimumKey));
        System.out.println("RedBlackBST rank of minimum key: -> " + studentRedBlackBST.rank(minimumKey));
        System.out.println("RedBlackBST floor value of minimum key - 1 : -> " + studentRedBlackBST.floor(minimumKey - 1));
        System.out.println("RedBlackBST ceil value of minimum key + 1 : -> " + studentRedBlackBST.ceil(minimumKey + 1));
        int maximumKey = studentRedBlackBST.getMaximum();
        System.out.println("RedBlackBST containsKey(" + maximumKey + "): -> " + studentRedBlackBST.containsKey(maximumKey));
        System.out.println("RedBlackBST maximum key: -> " + maximumKey + " value -> " + studentRedBlackBST.get(maximumKey));
        System.out.println("RedBlackBST rank of maximum key: -> " + studentRedBlackBST.rank(maximumKey));
        System.out.println("RedBlackBST floor value of maximum key - 1 : -> " + studentRedBlackBST.floor(maximumKey - 1));
        System.out.println("RedBlackBST ceil value of maximum key + 1 : -> " + studentRedBlackBST.ceil(maximumKey + 1));
        System.out.println("------------------------------------------------------------------------------");
        int start = 1390;
        int end = 1550;
        student = Student.getRandomStudentData();
        student.roll = end;
        studentRedBlackBST.put(student.roll, student);
        student.roll = start;
        studentRedBlackBST.put(student.roll, student);
        studentRedBlackBST.printSizeLeftAndRightSubtrees();
        System.out.println("RedBlackBST all keys: " + studentRedBlackBST.keys());
        System.out.println("RedBlackBST count of all keys between (" + start + ", " + end + "): " + studentRedBlackBST.countKeys(start, end));
        System.out.println("RedBlackBST all keys between (" + start + ", " + end + "): " + studentRedBlackBST.keys(start, end));
    }

    // function to test and compare The efficiency of RedBlackBST over normal BST when order
    public static void compareBSTAndRedBlackBST() {
        int length = 8191; // for (power of 2) - 1 RedBlackBST is fully balanced in all cases
        BST<Integer, Student> bst;
        RedBlackBST<Integer, Student> redBlackBST;
        Student student;
        System.out.println("--------------------------------------");
        bst = new BST<>();
        redBlackBST = new RedBlackBST<>();
        System.out.println("1. Random insertions");
        for (int i = 0; i < length; i++) {
            student = Student.getRandomStudentData();
            bst.put(student.roll, student);
            redBlackBST.put(student.roll, student);
        }
        bst.printSizeLeftAndRightSubtrees();
        redBlackBST.printSizeLeftAndRightSubtrees();
        System.out.println("--------------------------------------");
        bst = new BST<>();
        redBlackBST = new RedBlackBST<>();
        System.out.println("2. Ascending insertions");
        for (int i = 0; i < length; i++) {
            student = Student.getRandomStudentData();
            bst.put(i, student);
            redBlackBST.put(i, student);
        }
        bst.printSizeLeftAndRightSubtrees();
        redBlackBST.printSizeLeftAndRightSubtrees();
        System.out.println("--------------------------------------");
        bst = new BST<>();
        redBlackBST = new RedBlackBST<>();
        System.out.println("3. Descending insertions");
        for (int i = 0; i < length; i++) {
            student = Student.getRandomStudentData();
            bst.put(length - i, student);
            redBlackBST.put(length - i, student);
        }
        bst.printSizeLeftAndRightSubtrees();
        redBlackBST.printSizeLeftAndRightSubtrees();
        System.out.println("--------------------------------------");
    }

    // function to test SeparateChaining
    public static void studentHashSeparateChaining() {
        SeparateChaining<Student, String> separateChaining = new SeparateChaining<>();
        String section;
        Student student;
        for (int i = 0; i < 5; i++) {
            student = Student.getRandomStudentData();
            section = Random.string(1);
            System.out.println("get(" + student + ") => " + separateChaining.get(student));
            separateChaining.put(student, section);
            System.out.println("get(" + student + ") => " + separateChaining.get(student));
        }
        System.out.println(separateChaining);
    }

    // function to test LinearProbing
    public static void studentHashLinearProbing() {
        LinearProbing<Student, String> linearProbing = new LinearProbing<>();
        String section;
        Student student;
        for (int i = 0; i < 5; i++) {
            student = Student.getRandomStudentData();
            section = Random.string(1);
            System.out.println("get(" + student + ") => " + linearProbing.get(student));
            linearProbing.put(student, section);
            System.out.println("get(" + student + ") => " + linearProbing.get(student));
        }
        System.out.println(linearProbing);
    }

}
