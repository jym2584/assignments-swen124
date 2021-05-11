package assignment;

import java.util.*;

public class ScheduleMaker {
    /**
     * Add a random course from the list of courses
     * For all the list of courses
     *      If the courses don't overlap each other (start and end)
     *          Add them to the schedule
     *       
     * 
     * After looking at this again, I should sort them first by time start and duration and then iterate
     * 
     * @param courses list of available courses
     * @return returns a schedule with the most courses possible (?)
     */
    public static List<Course> makeSchedule(List<Course> courses) {
        courses.sort(new CourseComparator()); // Sorted our courses by start time and then duration (aka end time)
        List<Course> schedule = new LinkedList<>();
        schedule.add(courses.get(0)); // Adds a random course to the schedule
        
        for(int i = 1; i < courses.size(); i++) { // Selecting one course (excluding the one that we've already added)
            Course selectedCourse = courses.get(i);
            int count = 0; // Counting if there are no overlaps

            for(int j = 0; j < schedule.size(); j++) { // Going through all of our current courses to see if there is no overlaps from the selecting course
                Course currentCourses = schedule.get(j);

                if(!doesCoursesOverlap(selectedCourse, currentCourses))  { // If the selected course doesn't overlap any of the times on our schedule
                    count++;
                }
                if(count == schedule.size()) {
                    schedule.add(selectedCourse); // Add the new course to our schedule
                }

            }
        }

        return schedule; 
    }

    /**
     * Checks to see if an overlap exists between two courses
     * @param courseOne A course to compare
     * @param courseTwo A second course to compare
     * @return sees if a course overlaps or not
     */
    public static boolean doesCoursesOverlap(Course courseOne, Course courseTwo) {
        boolean overlap = courseOne.getStart() < courseTwo.getEnd() && courseTwo.getStart() < courseOne.getEnd();
        return overlap;
    }

    public static void main(String[] args) {
        // ***** Testing doesCoursesOverlap *****
            // Course courseOne = new Course("Programming", 8, 10);
            // Course courseTwo = new Course("Physics", 10, 12);
            // Course courseThree = new Course("Calculus", 9, 11);
            // Course courseFour = new Course("Design Patterns", 10, 11);

            // System.out.println(doesCoursesOverlap(courseOne, courseTwo));
            // System.out.println(doesCoursesOverlap(courseOne, courseThree));
            // System.out.println(doesCoursesOverlap(courseOne, courseFour));
            // System.out.println(doesCoursesOverlap(courseFour, courseTwo));
            // System.out.println(doesCoursesOverlap(courseThree, courseFour));

        List<Course> coursesList = Course.exampleCourses();

        // ***** Sorting our courses print test *****
            Collections.shuffle(coursesList);
            coursesList.sort(new CourseComparator());
            System.out.println(coursesList);

        System.out.println("\n\n");

        // Schedule List
        List<Course> schedule = makeSchedule(coursesList);
        schedule.sort(new CourseComparator());
        for(Course courses: schedule) {
            System.out.println(courses);
        }


        
    }
}