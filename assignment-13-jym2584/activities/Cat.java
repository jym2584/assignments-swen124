package activities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cat implements Comparable<Cat> {
    private String name;
    private String furColor;
    private int evil;

    public Cat(String name, String furColor, int evil) {
        this.name = name;
        this.furColor = furColor;
        this.evil = evil;
    }

    public int getEvil() {
        return evil;
    }
    public String getFurColor() {
        return furColor;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Cat o) {
        return name.compareTo(o.name);
    }

    public static void main(String[] args) {
        List<Cat> myCats = new ArrayList<>();
        myCats.add(new Cat("Gerald", "Brown", 19));

        Collections.sort(myCats);
    }

}
