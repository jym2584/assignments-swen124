package ssb;

import java.util.Arrays;

public class Attack {
    private String name;
    private int[] hits;

    public Attack(String name, int[] hits) {
        this.name = name;
        this.hits = hits;
    }

    public String getName() { return name; }
    public int[] getHits() { return hits; }

    @Override
    public String toString() { return "Attack {" + getName() + ": Deals " + Arrays.toString(hits) + " damage."; }
}
