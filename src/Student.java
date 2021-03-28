public class Student implements Comparable<Student> {
    int roll;
    String name;
    double marks;
    boolean pass;

    public Student(int roll, String name, double marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
        this.pass = checkIfPass();
    }

    public static Student getRandomStudentData() {
        return new Student(1000 + Random.intValue(1000), Random.string(9), Math.round(Random.doubleValue(100) * 100.0) / 100.0);
    }

    private boolean checkIfPass() {
        return marks >= 33.00;
    }

    private String isPass() {
        return pass ? "Pass" : "Fail";
    }

    @Override
    public int compareTo(Student that) {
        return (int) (this.marks - that.marks);
    }

    @Override
    public String toString() {
        return "Student: { roll: " + roll + ", name: " + name + ", marks: " + marks + ", result: " + isPass() + " }";
    }
}
