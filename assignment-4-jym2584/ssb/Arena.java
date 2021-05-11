package ssb;
import ssb.ssb_characters.*;

public class Arena {
    private Fighter fighter1;
    private Fighter fighter2;
    public Arena(Fighter fighter1, Fighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }
    public void battle(){
        System.out.println(fighter1.getName() + " and " + fighter2.getName() + " has joined the arena!\nFight!");
        while ((fighter1.isConscious()) && (fighter2.isConscious())) {
            fighter2.dealDamage(fighter1.attack());
            fighter1.dealDamage(fighter2.attack());
        }

        if ((fighter1.getHealth() <= 0) && (fighter2.getHealth() <= 0)) {
            System.out.println("Draw!");
        } else if (fighter1.getHealth() <= 0) {
            System.out.println(fighter2 + " wins!");
        } else if (fighter2.getHealth() <= 0) {
            System.out.println(fighter1 + " wins!");
        } else {
            System.out.println("hmm what could've gone wrong here? Probably nothing.. :sweat_smile: ");
        }

    }

    @Override
    public String toString() {
        if ((fighter1.getHealth() <= 0) && (fighter2.getHealth() <= 0)) {
            return "Draw!";
        } else if (fighter1.getHealth() <= 0) {
            return fighter2 + " wins!";
        } else if (fighter2.getHealth() <= 0) {
            return fighter1 + " wins!";
        } else {
            return fighter1 + " and " + fighter2 + " are on queue to battle!";
        }
    }
    public static void main(String[] args) {
        Manio mario = new Manio("Mario");
        Lonk link = new Lonk("Link");
        Arena arena = new Arena(mario, link);
        System.out.println(arena);
        arena.battle();

    }
}
