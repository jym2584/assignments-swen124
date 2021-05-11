package gvt;

public class Fighter {
    private String name;
    private static final int MAX_HP = 150;
    protected int currHp;

    public Fighter (String name) {
        this.name = name;
        currHp = MAX_HP;
    }


    @Override
    public String toString() {
        return name + "'s Hp: " + currHp;
    }

    public Attack attack() {
        int[] hits = {25};
        return new Attack("Cleave", hits, DamageType.PHYSICAL);
    }

    public void takeDamage(Attack attack) {
        float damage = 0;
        float multiplier = 1.0f;

        if (attack.getType() == DamageType.PHYSICAL) {
            multiplier = 0.75f;
        } 
        else if (attack.getType() == DamageType.MAGICAL) {
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

    public static void main(String[] args) {
        Mage gandolf = new Mage("Gandolf the Goat");
        Fighter gimli = new Fighter("Eleminister");

        System.out.println(gandolf);
        gandolf.takeDamage(gimli.attack());
        System.out.println(gandolf);
        System.out.println(gimli);
    }


}
