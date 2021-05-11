package ssb.ssb_characters;

import ssb.Attack;
import ssb.Fighter;

public class Manio extends Fighter {
    
    public Manio(String name) {
        super(name, 100);
    }

    @Override
    public Attack attack() {
        int[] hits = {randomNum(25, 50)};
        Attack attack = new Attack("Jump attack", hits);

        return attack;

    }

    @Override
    public void dealDamage(Attack attack) {
        int chance = randomNum(1,4);
        int damage = 0;
        if (chance > 1) { // 25% chance to dodge attack
            for (int i = 0; i < attack.getHits().length; i++) {
                damage += attack.getHits()[i];
            }
            
            reduceHealth(damage);
            isConscious();
            
            System.out.println( getName() + " has been damaged for " + damage + " health. (Current HP: " + getHealth() + ")");
        } else {
            System.out.println(getName() + " dodged the attack!");
        }
    }
    
    @Override
    public String toString() { return "Player " + getName() + " (HP: " + getHealth() + ")"; }

    public static void main(String[] args) {
        Manio mario = new Manio("Mario");
        Manio luigi = new Manio("Luigi");
        System.out.println(mario);
        mario.dealDamage(mario.attack());
        System.out.println(mario);
    }
}
