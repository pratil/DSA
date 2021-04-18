package util;

public class Student implements Comparable<Student> {
    Integer roll;
    String name;
    Integer marks;
    Boolean pass;
    private int hash = 0;

    public Student(Integer roll, String name, Integer marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
        this.pass = checkIfPass();
    }

    public static Student getRandomStudentData() {
        return new Student(1000 + Random.intValue(1000), Random.string(9), Random.intValue(100));
    }

    private boolean checkIfPass() {
        return marks >= 33.00;
    }

    private String isPass() {
        return pass ? "Pass" : "Fail";
    }

    public static void printArray(Student[] students) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("[\n");
        for (Student student : students)
            stringBuffer.append("  ").append(student).append("\n");
        stringBuffer.append("]");
        System.out.println(stringBuffer.toString());
    }

    @Override
    public String toString() {
        return "Student: { roll: " + roll + ", name: " + name + ", marks: " + marks + ", result: " + isPass() + " }";
    }

    @Override
    public int compareTo(Student that) {
        return (this.marks - that.marks);
//        return (this.roll - that.roll);
//        return this.name.compareTo(that.name);
    }

    @Override
    public int hashCode() {
        if (hash == 0) {
            hash = 17;
            hash = 31 * hash + roll.hashCode();
            hash = 31 * hash + name.hashCode();
            hash = 31 * hash + marks.hashCode();
            hash = 31 * hash + pass.hashCode();
        }
        return hash;
    }
}
