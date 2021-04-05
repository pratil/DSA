package util;

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
}
