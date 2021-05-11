package activities;

public class Ship {
    private String name;
    private int hullAmount;
    private int shields;
    private Weapon[] armament; // array of weapons
    private boolean isDestroyed;

    public Ship(String name, int hullAmount, int shields) {
        this.name = name;
        this.hullAmount = hullAmount;
        this.shields = shields;
        //this.armament = armament;
        armament = new Weapon[0]; // doesn't need "this." because no parameter on method
        isDestroyed = false;
    }
    
    @Override
    public String toString() {
        return name + ": shields " + shields + ", hull " + hullAmount; 
    }

    public Ship(String name, int hullAmount) {
        this(name, hullAmount, 0);
    }

    public String getName() { return name; }
    public int getHullAmount() { return hullAmount; }
    public int getShields() { return shields; }
    public Weapon[] getWeapons() { return armament; }
    public boolean isDestroyed() { return isDestroyed; }

    public void takeDamage(int damageAmount) {
        shields = shields - damageAmount; // shield taking damage first
        if (shields < 0) {
            hullAmount += shields;
        }
        
        if (hullAmount <= 0) {
            isDestroyed = true;
        }
    }


    @Override
    public boolean equals (Object o) {
        if (!(o instanceof Ship)) {
            return false;
        }
    

        Ship other = (Ship)(o);
        return name.equals(other.name);
    }



}
