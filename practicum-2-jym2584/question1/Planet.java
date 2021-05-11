package question1;

public class Planet implements Comparable<Planet> {
    private final String name;
    private final long diamaterKM;
    private final long orbitKM;

    public Planet(String name, long diamaterKM, long orbitKM){
        this.name = name;
        this.diamaterKM = diamaterKM;
        this.orbitKM = orbitKM;
    }

    public String getName() {
        return name;
    }
    
    public long getDiamaterKM() {
        return diamaterKM;
    }

    public long getOrbitKM() {
        return orbitKM;
    }

    @Override
    public String toString() {
        return name + " Diamater = " + diamaterKM + ", Orbit = " + orbitKM;
    }

    @Override
    public int compareTo(Planet o) {
        return (int)diamaterKM - (int)o.diamaterKM;
    }
}
