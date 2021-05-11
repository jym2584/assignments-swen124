package ssb.ssb_characters;

import ssb.Attack;
import ssb.Fighter;

public class Lonk extends Fighter {
    
    public Lonk(String name) {
        super(name, 150);
    }

    @Override
    public Attack attack() {
        int[] hits = {45};
        Attack attack = new Attack("Sword", hits);

        return attack;
    }

    @Override
    public void dealDamage(Attack attack) {
        int damageTotal = 0;
        int damage = 0;
        for (int hit : attack.getHits()) {
            int chance = randomNum(1,2);
            if (chance == 1) {
                damageTotal += hit;
                damage += hit/2;
                System.out.println(getName() + " blocked " + (hit - hit/2) + " damage! (" + hit + " potential)");

            } else {
                damageTotal += hit;
                damage += hit;
            }
        }    
        reduceHealth(damage);
        isConscious();
        
        System.out.println( getName() + " has been damaged for " + damage + " health. (Current HP: " + getHealth() + " | "+ (damageTotal - damage) + " blocked total)");

    }
    
    @Override
    public String toString() { return "Player " + getName() + " (HP: " + getHealth() + ")"; }

    public static void main(String[] args) {
        Fighter mario = new Manio("Manio");
        Fighter link = new Lonk("Lonk");
        System.out.println(mario);
        System.out.println(link);
        //mario.dealDamage(link.attack());
        link.dealDamage(mario.attack());
        System.out.println(mario);
        System.out.println(link);
    }
}
