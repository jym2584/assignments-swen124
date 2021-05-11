package activities;

import java.util.Comparator;

public class CatComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getFurColor().equals(o2.getFurColor())) {
            return o2.getEvil() - o1.getEvil();
        } else {
            return o1.getFurColor().compareTo(o2.getFurColor());
        }
    }
    
}
