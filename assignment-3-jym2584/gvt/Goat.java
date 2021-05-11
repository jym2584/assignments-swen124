package gvt;

public abstract class Goat extends Character {
    public Goat (String name, int hp) {
        super(name, hp);
    }

    public boolean isConscious() {
        return currHp < 0;
    }

    @Override
    public String toString() {
        return getName() + "'s Hp: " + currHp;
    }

    public abstract Attack attack(); // I need this, but I can't tell you what it does. I'll let you tell my children what it does
        // I want to attack this signature to this type
        // I just want to give you a name to look up, but not the implementation

    public void heal(int amount) {
        increaseHP(amount);
    }

    public abstract void takeDamage(Attack attack);


}
