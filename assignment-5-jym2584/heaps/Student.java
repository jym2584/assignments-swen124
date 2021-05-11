package heaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Student implements Comparable<Student> {
    private int id;
    private String name;


    public Student (int id, String name) {
        this.id = id;
        this.name = name;

    }
    @Override
    public String toString() {
        return name + ":" + id;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Student o) {
        //return name.compareTo(o.name);
        return id - o.id;
    }
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Student stu1 = new Student (5, "x");
        Student stu2 = new Student (3, "b2");
        Student stu3 = new Student (9, "j3");
        Student stu4 = new Student (1, "n4");
        Student stu5 = new Student (12, "a5");

        set = new TreeSet<>();
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        set.add(stu4);
        set.add(stu5);       

        Map<String, Student> map = new HashMap<>();
        map.put(stu1.getName(), stu1);
        map.put(stu2.getName(), stu2);
        map.put(stu3.getName(), stu3);
        map.put(stu4.getName(), stu4);
        map.put(stu5.getName(), stu5);

        for (Student stu: set) {
            System.out.println(stu);
        }

        System.out.println("Map");

        for (String stu: map.keySet()) {
            System.out.println("map[" + stu + "] = " + map.get(stu));
        }

        Map<Integer, Student> map2 = new TreeMap<>(); 
        map2.put(stu1.getId(), stu1);
        map2.put(stu2.getId(), stu2);
        map2.put(stu3.getId(), stu3);
        map2.put(stu4.getId(), stu4);
        map2.put(stu5.getId(), stu5);

        for (String id : map.keySet()) {
            System.out.println("map[" + id + "]" + map.get(id));
        }
    }

}