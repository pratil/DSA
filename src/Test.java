import queue.Queue;
import sort.Order;
import sort.Selection;
import stack.Stack;

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

    public static void studentSelectionSort() {
        Selection<Student> selection = new Selection<>();
        Student[] students = new Student[10];
        int length = students.length;
        for (int i = 0; i < length; i++)
            students[i] = Student.getRandomStudentData();
        System.out.println("Student array before sorting");
        Student.printArray(students);
        selection.sort(students);
        System.out.println("Student array after sorting in " + Order.Ascending + " order");
        Student.printArray(students);
        selection.sort(students, Order.Descending);
        System.out.println("Student array after sorting in " + Order.Descending + " order");
        Student.printArray(students);
    }
}
