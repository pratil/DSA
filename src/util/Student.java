package util;

// A class to test all the other data structures and sorting methods
public class Student implements Comparable<Student> {

    enum Result {
        Pass, Fail
    }

    Integer roll; // to store the Roll number of s student
    String name; // to store the name of the student
    Integer marks; // to store the marks of the student
    Result result; // to store the result of student if pass True else False
    private int hash = 0; // to store the hashcode of the student (only required for Symbol tables operations)

    // simple constructor to store the data of students and assign him/her fail or pass based on marks
    public Student(Integer roll, String name, Integer marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
        this.result = checkIfPass();
    }

    // to generate a random student Object with random data using the Random class
    public static Student getRandomStudentData() {
        return new Student(1000 + Random.intValue(1000), Random.string(9), Random.intValue(100));
    }

    // to check if the student with given marks is Pass or Fail
    private Result checkIfPass() {
        return marks >= 33.00 ? Result.Pass : Result.Fail;
    }

    // to get result of the student
    private String isPass() {
        return result.toString();
    }

    // to print the Array of Student objects in a proper format (as i liked it 😁)
    public static void printArray(Student[] students) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("[\n");
        for (Student student : students)
            stringBuffer.append("  ").append(student).append("\n");
        stringBuffer.append("]");
        System.out.println(stringBuffer);
    }

    // to print the student object (as i liked it 😁)
    @Override
    public String toString() {
        return "Student: { roll: " + roll + ", name: " + name + ", marks: " + marks + ", result: " + isPass() + " }";
    }

    // to compare two different Students data, depending upon: marks, or roll number, or name (only required for Sorting or Comparing objects)
    @Override
    public int compareTo(Student that) {
        return (this.marks - that.marks);
//        return (this.roll - that.roll);
//        return this.name.compareTo(that.name);
    }

    // to calculate and store the hashcode for student (only required for Symbol tables operations)
    @Override
    public int hashCode() {
        if (hash == 0) {
            hash = 17;
            hash = 31 * hash + roll.hashCode();
            hash = 31 * hash + name.hashCode();
            hash = 31 * hash + marks.hashCode();
            hash = 31 * hash + result.hashCode();
        }
        return hash;
    }

    // to check two objects are equal or not (only required for Symbol tables operations)
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Student))
            return false;
        Student student = (Student) o;
        return this.roll.compareTo(student.roll) == 0 && this.name.compareTo(student.name) == 0
                && this.marks.compareTo(student.marks) == 0 && this.result.compareTo(student.result) == 0
                && this.hash == student.hash;
    }
}
