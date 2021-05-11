package kfp;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class Panda<T> {
    private T weapon;
    private String name;

    public Panda(T weapon, String name) {
        this.weapon = weapon;
        this.name = name;
    }

    public void strike() {
        if (weapon instanceof Naginata) {
            System.out.println( ((Naginata)weapon).toString() );
        } else if (weapon instanceof Fist) {
            System.out.println( ((Fist)weapon).toString() );
        } else if (weapon instanceof Flowers) {
            System.out.println( ((Flowers)weapon).toString() );
        }
    }
    public static void main(String[] args) {
        Panda<Fist> panda = new Panda<>(new Fist(), "PAnda");
        panda.strike();
    }

    public static ArrayList<String> unique(String[] names){
        ArrayList<String> name = new ArrayList<>();
        HashSet<String> unique_names = new HashSet<>();

        for (String each_name: names) {
            unique_names.add(each_name);
        }

        for(String filtered_names: unique_names) {
            name.add(filtered_names);
        }

        return name;

    }
}
