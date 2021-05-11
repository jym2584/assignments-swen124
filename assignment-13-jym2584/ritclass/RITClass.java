package ritclass;

import java.util.*;

/**
 * I'm confused on how to naturally sort both of them using Comparable
 */
public class RITClass implements Comparable<RITClass> {
    
    /**
     * Sorting method 1
     *    - Sorts by department, course number and section number in ascending order
     */


    public static class ClassesSortAll implements Comparator<RITClass> {

        @Override
        public int compare(RITClass o1, RITClass o2) {
            int compareByDept = o1.deptCode.compareTo(o2.deptCode);
            int compareByCourseNum = Integer.compare(o1.courseNum, o2.courseNum);
            int compareBySectionNum = Integer.compare(o1.sectionNum, o2.sectionNum);

            if (compareByDept != 0) {
                return compareByDept;
            } else if (compareByCourseNum != 0) {
                return compareByCourseNum;
            } else {
                return compareBySectionNum;
            }

        }
        
    }


    /**
     * Sorting method 2
     *    - Sorts by department in ascending order and course number in descending order 
     */

     /*
    public static class ClassesSortSome implements Comparator<RITClass> {

        @Override
        public int compare(RITClass o1, RITClass o2) {
            int compareByDept = o1.deptCode.compareTo(o2.deptCode);
            int compareByCourseNum = Integer.compare(o2.courseNum, o1.courseNum);

            if (compareByDept != 0) {
                return compareByDept;
            } else {
                return compareByCourseNum;
            }

        }
        
    }
    
    */

        /**
     * Implementation of natural sorting 
     * Sorting method 1
     *    - Sorts by department, course number and section number in ascending order 
     */

    /*
    @Override       
    public int compareTo(RITClass o) {
        int compareByDept = deptCode.compareTo(o.deptCode);
        int compareByCourseNum = Integer.compare(courseNum, o.courseNum);
        int compareBySectionNum = Integer.compare(sectionNum, o.sectionNum);

        if (compareByDept != 0) {
            return compareByDept;
        } else if (compareByCourseNum != 0) {
            return compareByCourseNum;
        } else {
            return compareBySectionNum;
        }
    }
    */



    /**
     * Implementation of natural sorting 
     * Sorting method 2
     *    - Sorts by department in ascending order and course number in descending order 
     */
    @Override       
    public int compareTo(RITClass o) {
        int compareByDept = deptCode.compareTo(o.deptCode);
        int compareByCourseNum = Integer.compare(o.courseNum, courseNum);

        if (compareByDept != 0) {
            return compareByDept;
        } else {
            return compareByCourseNum;
        }
    }


    private final String code;
    private final String deptCode;
    private final int courseNum;
    private final int sectionNum;
    private String[] parsed;

    public RITClass(String code) {
        this.code = code;

        parsed = code.split("[\\s-]+"); // split by space and comma

        this.deptCode = parsed[0];
        this.courseNum =  Integer.parseInt(parsed[1]);
        this.sectionNum = Integer.parseInt(parsed[2]);
    }

    @Override
    public String toString() {
        return String.format("%s %d-%d", deptCode, courseNum, sectionNum);
    }

    public static void main(String[] args) {
        List<RITClass> classes = new ArrayList<>();
        classes.add(new RITClass("SWEN 344 05"));
        classes.add(new RITClass("SWEN-344 01"));
        classes.add(new RITClass("SWEN 261-02"));
        classes.add(new RITClass("COMM 201 06"));
        classes.add(new RITClass("STSO-120 02"));
        classes.add(new RITClass("PHYS 211-02"));

        List<RITClass> sortOne = new ArrayList<>(classes);
        List<RITClass> sortTwo = new ArrayList<>(classes);
        
        
        sortOne.sort(new ClassesSortAll());
        Collections.sort(sortTwo);

        System.out.println(String.format("Original list: %s %nSorting Method 1: %s %nSorting Method 2: %s", classes, sortOne, sortTwo));
    }

}