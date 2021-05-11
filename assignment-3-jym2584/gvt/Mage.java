package gvt;

public class Mage extends Goat{

    private String title;

    public Mage (String name) {
        super (name, 100);
        title = "Sir";
    }

    @Override
    public Attack attack() {
        int[] hits = {9,9,9,9};
        return new Attack("Magic Missle", hits, DamageType.MAGICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        float damage = 0;
        float multiplier = 1.0f;

        if (attack.getType() == DamageType.MAGICAL) {
            multiplier = 0.75f;
        } 
        else if (attack.getType() == DamageType.PHYSICAL) {
            multiplier = 1.25f;
        }

        for (int hit : attack.getHits()) {
            damage += hit * multiplier;
        }

        if (damage > currHp) {
            currHp = 0;
        }
        else {
            currHp -= damage;
        }
    }

    public String getTitle() {
        return title;
    }

    public static void main(String[] args) {
        Goat gandolf = new Mage("Gandolf the Goat");
        Goat eleminister = new Mage("Eleminister");

        System.out.println(gandolf);
        gandolf.takeDamage(eleminister.attack());
        System.out.println(gandolf);
    }
}