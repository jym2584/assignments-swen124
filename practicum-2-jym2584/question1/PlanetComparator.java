package question1;

import java.util.Comparator;

public class PlanetComparator implements Comparator<Planet> {

    @Override
    public int compare(Planet o1, Planet o2) {
        Long orbitKM = o1.getOrbitKM();
        Long orbit2KM = o2.getOrbitKM();
        return Long.compare(orbitKM, orbit2KM);
    }
    
}
