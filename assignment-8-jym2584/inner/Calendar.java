package inner;
import java.util.*;

public class Calendar {
    public enum DayOfWeek {
        SUNDAY (1, "Sun"), 
        MONDAY (2, "Mon"), 
        TUESDAY(3, "Tue"), 
        WEDNESDAY(4, "Wed"), 
        THURSDAY(5, "Thu"), 
        FRIDAY(6, "Fri"), 
        SATURDAY(7, "Sat");

        private final int number;
        private final String shortName;
        private static final Map <DayOfWeek, DayOfWeek> NEXT_DAYS = new HashMap<>();

        static {
            NEXT_DAYS.put (SUNDAY, MONDAY);
            NEXT_DAYS.put (MONDAY, TUESDAY);
            NEXT_DAYS.put (TUESDAY, WEDNESDAY);
            NEXT_DAYS.put (WEDNESDAY, THURSDAY);
            NEXT_DAYS.put (THURSDAY, FRIDAY);
            NEXT_DAYS.put (FRIDAY, SATURDAY);
            NEXT_DAYS.put (SATURDAY, SUNDAY);
        }
        private DayOfWeek (int number, String shortName) {
            this.number = number;
            this.shortName = shortName;
        }
        public DayOfWeek tomorrow() {
            return NEXT_DAYS.get(this);
        }

        @Override
        public String toString() {
            return shortName;
        }
    }

    public enum Month implements Iterable <DayOfWeek> {
        JANUARY(31), FEBRUARY (28), MARCH (31), APRIL(30), MAY(31), JUNE(30),
        JULY(31), AUGUST (31), SEPTEMBER (30), OCTOBER(31), NOVEMBER(30), DECEMBER (31);
        private int daysInMonth;
        private DayOfWeek startDay;
        private static final Map <Month, Month> NEXT_MONTHS = new HashMap <>();

            static {
                NEXT_MONTHS.put (JANUARY, FEBRUARY);
                NEXT_MONTHS.put (FEBRUARY, MARCH);
                NEXT_MONTHS.put (MARCH, APRIL);
                NEXT_MONTHS.put (APRIL,MAY);
                NEXT_MONTHS.put (MAY, JUNE);
                NEXT_MONTHS.put (JUNE, JULY);
                NEXT_MONTHS.put (JULY, AUGUST);
                NEXT_MONTHS.put (AUGUST, SEPTEMBER);
                NEXT_MONTHS.put (SEPTEMBER, OCTOBER);
                NEXT_MONTHS.put (OCTOBER, NOVEMBER);
                NEXT_MONTHS.put (NOVEMBER, DECEMBER);
                NEXT_MONTHS.put (DECEMBER, JANUARY);
               

            }

        private Month(int daysInMonth) {
            this.daysInMonth = daysInMonth;
            startDay = DayOfWeek.SUNDAY;
        }

        public void setStartDay (DayOfWeek startDay) {
            this.startDay = startDay;
        }

        public Month nextMonth() {
            return NEXT_MONTHS.get(this);
        }

        @Override
        public Iterator<DayOfWeek> iterator() {
            //DayOfWeek day = startDay;
            return new Iterator<DayOfWeek>(){
                private int counter = 0;
                private DayOfWeek day = startDay;

                @Override
                public boolean hasNext() {
                    return counter < daysInMonth;
                }

                @Override
                public DayOfWeek next() {
                    DayOfWeek today = day; 
                    day = today.tomorrow();
                    counter++;
                    return today;
                }
            };
        }
    }
    public static void main(String[] args) {
        int count = 1;

        Month.MARCH.setStartDay(DayOfWeek.MONDAY);
        System.out.println("MARCH");
        for(DayOfWeek day: Month.MARCH) {
            System.out.print(count + "-" + day+ " ");
            if(day == DayOfWeek.SATURDAY) {
                System.out.println();
            }
            count++;
        }
    }
}
