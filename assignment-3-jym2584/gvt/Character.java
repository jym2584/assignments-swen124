package gvt;

public abstract class Character {
    private final String name;
    private final int maxHP;
    protected int currHp;

    public Character (String name, int hp) {
        this.name = name;
        maxHP = hp;
        currHp = maxHP;
    }


    public String getName() {
        return name;
    }

    public int getmaxHP() {
        return maxHP;
    }

    public int getCurrHP() {
        return currHp;
    }

    @Override
    public String toString() {
        return name + "'s Hp: " + currHp;
    }

    public abstract Attack attack(); // I need this, but I can't tell you what it does. I'll let you tell my children what it does
        // I want to attack this signature to this type
        // I just want to give you a name to look up, but not the implementation

    public abstract void takeDamage(Attack attack);

    protected void increaseHP(int amount) {
        currHp += amount;
        if (currHp > maxHP) {
            currHp = maxHP;
        }        
    }

}
