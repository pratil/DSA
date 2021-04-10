package util;

import binaryHeap.MaxHeapTree;
import binaryHeap.MinHeapTree;
import bst.BST;
import bst.RedBlackBST;
import queue.Queue;
import sort.*;
import stack.Stack;

import java.util.Arrays;

public class Test {
    public static void studentStack() {
        Stack<Student> studentStack = new Stack<>();
        System.out.println(studentStack);
        for (int i = 0; i < 10; i++)
            studentStack.push(Student.getRandomStudentData());
        System.out.println(studentStack);
        System.out.println("studentStack.peek()=> " + studentStack.peek());
        System.out.println("studentStack.size()=> " + studentStack.size());
        System.out.println("studentStack.isEmpty()=> " + studentStack.isEmpty());
    }

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

    public static void studentSelectionSort() {
        Sort<Student> selection = new Selection<>();
        studentSort(selection);
    }

    public static void studentInsertionSort() {
        Sort<Student> insertion = new Insertion<>();
        studentSort(insertion);
    }

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

    public static void studentMergeSort() {
        Sort<Student> merge = new Merge<>();
        studentSort(merge);
    }

    public static void studentHeapSort() {
        Sort<Student> heap = new Heap<>();
        studentSort(heap);
    }

    public static void studentQuickSort() {
        Sort<Student> quick = new Quick<>();
        studentSort(quick, 1000);
    }

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
        System.out.println("BST count of all keys between (" + start + ", " + end + "): " + studentBST.rangeCount(start, end));
        System.out.println("BST all keys between (" + start + ", " + end + "): " + studentBST.rangeKeys(start, end));
    }

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
        System.out.println("RedBlackBST count of all keys between (" + start + ", " + end + "): " + studentRedBlackBST.rangeCount(start, end));
        System.out.println("RedBlackBST all keys between (" + start + ", " + end + "): " + studentRedBlackBST.rangeKeys(start, end));
    }

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

}
