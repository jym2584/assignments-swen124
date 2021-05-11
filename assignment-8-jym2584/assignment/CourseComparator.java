package assignment;

import java.util.Comparator;

public class CourseComparator implements Comparator<Course> {

    /**
     * Comparator for sorting courses by time and then duration 
     */
    @Override
    public int compare(Course o1, Course o2) {
        Integer courseOneTime = o1.getStart();
        Integer courseTwoTime = o2.getStart();

        int timeCompare = courseOneTime.compareTo(courseTwoTime); // Comparing start times
        if (timeCompare != 0) {
            return timeCompare;
        }

        Integer courseOneDuration = o1.duration(); // Comparing duration or end time
        Integer courseTwoDuration = o2.duration();
        return courseOneDuration.compareTo(courseTwoDuration);

    }
}
