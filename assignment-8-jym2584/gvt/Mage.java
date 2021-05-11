package gvt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mage extends Goat {

    /**
     * Mage ability list. There is one list for all mages.
     */
    private static final Map <String, Ability> abilities = new HashMap<> ();
    static {
        /**
         * Used basic attack here instead
         */
        abilities.put ("Staff Attack", (enemies, party) -> {
            Goat.basicAttack(enemies, party);
        });

        abilities.put("Magic Missiles", new Ability(){
            /**
             * Magic missiles ability
             * Attacks 4 times at random enemies
             */
            @Override
            public void use(List<Troll> enemies, List<Goat> party) {
                int[] hits = {9};
                for (int i = 0; i < 4; i++) {
                    Troll target = getRandomTarget(enemies);
                    target.takeDamage(new Attack("", hits, DamageType.MAGICAL));
                    removeVanquished(enemies, target);
                }
                
            }
            
        });
        /**
         * Davy Crockett ability
         * Attacks for 25 damage at a random enemy if they are a Trollzord
         * Trollings can dodge the attack
         */
        abilities.put("Davy Crockett", (enemies, party) -> {
            int[] hits = {50};
            Troll target = getRandomTarget(enemies);
            if (target.getName().equals("Trollzord")) {
                target.takeDamage(new Attack("", hits, DamageType.MAGICAL));
                removeVanquished(enemies, target);
            } else {
                System.out.println("        " + target.getName() + " was fast enough to dodge the explosion!" + getName());
            }
            
        });
    }

    public Mage(String name) {
        super(name, 100, abilities);
    }

    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 0.75;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);
    }

    @Override
    public Attack attack() {
        // TODO Auto-generated method stub
        return null;
    }
}
