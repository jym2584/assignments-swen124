package friday;

import java.util.Arrays;
import java.util.Random;
/**
 * Class used to store year and get the number of days
 * in it
 */
public class Year {
    /**
     * Number of days in a standard (non-leap) year
     */
    public static final int DAYS_IN_YEAR = 365;
    private final int yearNumber; // compile will enforce that yearNumber cannot be changed

    /**
     * Constructor
     * @param year calendar year number
     */
    public Year(int year) {
        yearNumber = year;
    }

    /**
     * Returns the calendar year number
     * @return calendar year number
     */
    public int getYearNumber() {
        return yearNumber;
    }

    public int numberOfDays() {
        return daysInYear(yearNumber);
    }


    /**
     * Calculates the number of days in the specified year
     * 
     * @param year year to calculate days for
     * @return number of days in the supplied year
     */
    public static int daysInYear(int year) {
        if (year % 400 == 0) {
            return DAYS_IN_YEAR + 1;
        }
        else if (year % 100 == 0) {
            return DAYS_IN_YEAR;
        }
        else if (year % 4 == 0) {
            return DAYS_IN_YEAR + 1;
        }
        else {
            return DAYS_IN_YEAR;
        }

    }



    public void changeYear(int year) {
        yearNumber = year; // compiler will reject this because changing yearNumber isn't allowed=
    }


    public static Year[] parseYears(String yearsStr) {
        yearsStr = yearsStr.trim();
        String[] tokens = yearsStr.split(" ");

        Year[] years = new Year[tokens.length];
        for (int i = 0; i < years.length; i++) {
            years[i] = new Year(Integer.parseInt(tokens[i]));
        }

        return years;
    }

    @Override
    public String toString() {
        return "Year {Year " + yearNumber + " Days " + DAYS_IN_YEAR + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Year)) {
            return false;
        }

        Year other = (Year)o;
        return yearNumber == other.yearNumber;
    }

    public static Year randomYear() {
        Random random = new Random();
                        // max - min + 1;
        //int upperBound = 2021 - 1900 + 1;
        //int number = random.nextInt(upperBound);

        //return number + 1900;

        int yearNumber = random.nextInt(122) + 1900;
        return new Year(yearNumber);
    }

    public static void main(String[] args) {
        Year thisyear = new Year(2021);
        System.out.println(thisyear.getYearNumber() + " has " + thisyear.numberOfDays() + " days in it");
        System.out.println(thisyear);
        Year alsothisyear = new Year(2021);
        Year nextyear = new Year(2022);
        System.out.println(thisyear.equals(alsothisyear));
        System.out.println(thisyear.equals(nextyear));

        Year[] years = Year.parseYears("2000 2010 2020 2030");
        for (Year year : years) {// for each loop
            System.out.println(year);
        }
        System.out.println("");
        for (int i = 0; i < 5; i++) {
            System.out.println(Year.randomYear());
        }
    }
}
