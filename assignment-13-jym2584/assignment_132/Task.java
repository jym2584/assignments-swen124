package assignment_132;

import java.util.*;

public class Task implements Comparable<Task> {
    private final String name;
    private final int hours;

    public Task(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Task o) {
        int compareByHours = Integer.compare(hours, o.hours);
        int compareByName = name.compareTo(o.name);
        
        if(compareByHours != 0) {
            return compareByHours;
        } else {
            return compareByName;
        }
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof Task)) {
            return false;
        }
    
        Task other = (Task)(o);
        return name == other.name && hours == other.hours;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Task{%s, %s}", name, hours);
    }

    public static final TreeSet<Task> tasks = new TreeSet<>(); static {
        tasks.add(new Task("Mop", 2));
        tasks.add(new Task("Sweep", 1));
        tasks.add(new Task("Clean Office", 6));
        tasks.add(new Task("Laundary", 3));
        tasks.add(new Task("Landscaping", 4));
        tasks.add(new Task("Clean Basement", 5));
        tasks.add(new Task("A task to see if names are also compared", 6));
    }

    public static List<Task> getMostTasks(int hours) {
        List<Task> optimalTasks = new ArrayList<>();

        int total = 0;
        for(Task task: tasks) {
            // If the task exceeds less than the max and the added hours so far has not reached the 'hours' threshold
            if(task.getHours() + total <= hours && total < hours) {
                optimalTasks.add(task); // add it
                total += task.getHours();
            }
        }

        return optimalTasks;

    }

    public static void main(String[] args) {
        System.out.println(tasks);

        System.out.println(getMostTasks(6));
        
    }
}