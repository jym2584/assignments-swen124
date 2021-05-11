package gvt;

public class Trollzard extends Troll{

    public Trollzard () {
        super ("Trollzard", 64, 5);
    }

    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("Flame War", hits, DamageType.MAGICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        float damage = 0;
        float multiplier = 1.0f;

        if (attack.getType() == DamageType.HOLY) {
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
        Troll gandolf = new Trollzard();
        Troll eleminister = new Trollzard();

        System.out.println(gandolf);
        gandolf.takeDamage(eleminister.attack());
        System.out.println(gandolf);
    }
}