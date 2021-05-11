package activities;

public class Weapon {
    public static final String ION_DAMAGE_COLOR = "Blue";
    public static final String NORMAL_DAMAGE_COLOR = "Red";
    public static final String HEAVY_DAMAGE_COLOR = "Green";

    private String name;
    private int damageAmount;
    private DamageType damageType;
    //private String color;

    public Weapon(String name, int damage, DamageType type) {
        this.name = name;
        damageAmount = damage;
        damageType = type;
        //this.color = color;
    }

    @Override
    public String toString() {
        return name + ": fires " + damageType + " blasts for " + damageAmount + " damage.";
    }

    public String getName() { return name; }
    public int getDamageAmount() { return damageAmount; }
    public DamageType getDamageType() { return damageType; }
    public String getColor() { return damageType.toString(); }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof Weapon)) {
            return false;
        }
    

        Weapon other = (Weapon)(o);
        return ( (damageAmount == other.damageAmount) && damageType.equals(other.damageType) );
    }

}