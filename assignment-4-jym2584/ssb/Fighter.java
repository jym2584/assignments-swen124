package ssb;
import java.util.Random;

public abstract class Fighter {
    private String name;
    private int maxHealth;
    private int health;
    private Attack attack;
    public Fighter (String name, int health) {
        this.name = name;
        this.maxHealth = health;
        this.health = maxHealth;
    }

    public abstract Attack attack();
    public abstract void dealDamage(Attack attack);

    public void reduceHealth(int amount) { 
        health -= amount; 
    }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public Attack getAttack() { return attack; }
    public boolean isConscious() {
        if (health <= 0) {
            this.health = 0;
            return false;
        } else {
            return true;
        }
    }
    public static int randomNum(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
