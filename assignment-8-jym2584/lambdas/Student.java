package lambdas;
import java.util.*;

public class Student {
    private final String firstName;
    private final String lastName;
    private double gpa;
    public Student(String firstName, String lastName, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " GPA: " + gpa;
    }


    public int compareTo(Student o) {
        return firstName.compareTo(o.firstName);

    }

    public String getLast() { return lastName; }
    public String getFirst() { return firstName; }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student stu1 = new Student("Dello", "World", 3.6);
        Student stu2 = new Student("Ein", "Moon", 2.9);
        Student stu3 = new Student("Bruce", "Herring", 3.4);
        Student stu4 = new Student("Aohn", "Doe", 4.0);
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        System.out.println(students);

        //students.sort(new Comparator<Student> () {
        //     
        //    @Override
        //    public int compare(Student o1, Student o2) {
        //        return o1.lastName.compareTo(o2.lastName);
        //    }
        //});

        //students.sort((o1, o2) -> o2.firstName.compareTo(o1.firstName));
        
        students.sort(Student::compareTo);
        System.out.println(students);

        students.stream().forEach(e -> System.out.println(e.firstName + " " + e.lastName));
        System.out.println("GPA");
        students.stream().filter(e -> e.gpa >= 3.6).forEach(System.out::println);

        
        
    }

    
}
