public class Student implements Comparable<Student> {
    Integer roll;
    String name;
    Integer marks;
    Boolean pass;

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
        return this.marks - that.marks;
//        return (this.roll - that.roll);
//        return this.name.compareTo(that.name);
    }
}
