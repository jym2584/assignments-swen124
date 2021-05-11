package gvt;

public abstract class Troll extends Character {
    private int regen;
    public Troll(String name, int hp, int regen) {
        super(name, hp);
        this.regen = regen;
    }


    public boolean isVanquished() {
        if (currHp == 0){
            return true;
        }
        return false;
    }

    public void regen() {
        int amount = getmaxHP() * regen / 100;
        increaseHP(amount);
    }

    public abstract Attack attack();
    public abstract void takeDamage(Attack attack);

    @Override
    public String toString() {
        return getName() + "'s Hp: " + getCurrHP();
    }

}
