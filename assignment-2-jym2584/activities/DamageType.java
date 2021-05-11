package activities;

public enum DamageType {
    NORMAL(Weapon.NORMAL_DAMAGE_COLOR),
    HEAVY(Weapon.HEAVY_DAMAGE_COLOR),
    ION(Weapon.ION_DAMAGE_COLOR);

    private String color;

    private DamageType (String color) {
        this.color = color;
    }
    
    public String toString() {
        return color;
    }

}
