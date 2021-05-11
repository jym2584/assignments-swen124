package activities;
// javac .\activities\*.java

import java.util.Arrays;

public class StarWarsBattle {
    public static void main(String[] args) {
        Weapon blaster = new Weapon("Blaster", 50, DamageType.ION);
        System.out.println(blaster);
        System.out.println(blaster.getColor());
        Weapon laser = new Weapon("Laserr", 50, DamageType.ION);
        System.out.println(laser);

        Weapon heavyblaster = new Weapon("Heavy Blaster", 100, DamageType.HEAVY);
        System.out.println(heavyblaster);

        System.out.println(blaster + " == " + blaster + ": " + (blaster.equals(blaster)));
        System.out.println(blaster + " == " + laser + ": " + (blaster.equals(laser)));
        System.out.println(blaster + " == " + heavyblaster + ": " + (blaster.equals(heavyblaster)));

        Ship myShip = new Ship("X-Wing", 50);
        System.out.println(myShip);
        //System.out.println(myShip.getName() + " " + myShip.getHullAmount() + " " + myShip.getShields() + " " + Arrays.toString(myShip.getWeapons()));

    }
}
