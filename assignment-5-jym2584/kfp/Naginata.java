package kfp;


public class Naginata {
    private double damage;

    public <T> Naginata(int damage) {
        this.damage = damage;        
    }

    @Override
    public String toString(){
        return "A flashy wieldy sword that looks like a katana, but it's actually a staff-mounted blade dealing damage!" + damage;
    }

    public double attack(){
        return damage;

    }
}
