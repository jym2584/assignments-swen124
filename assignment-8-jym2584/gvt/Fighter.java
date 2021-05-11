package gvt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fighter extends Goat {

    /**
     * Fighter ability list. There is one list for all fighters.
     */
    private static final Map <String, Ability> abilities = new HashMap<> ();

    static {
        /**
         *  Basic attack for fighter
         */
        abilities.put ("Punch", (enemies, party) -> {
            Goat.basicAttack(enemies, party);
        });
        
        /**
         * Cleave ability
         * First target takes 25 damage and the other 2 takes 13 damage
         * Other target takes only 13 damage if there are 2 enemies
         */
        abilities.put("Cleave", (enemies, party) -> {
            boolean usedCritical = false;
            int[] criticalHit = {25};
            int[] hits = {13};

            // Sets a limit as to how many times the cleave can hit depending on how many enemies are present on the fight.
            int numTimesToHit;
            if(enemies.size() >= 3) {
                numTimesToHit = 3;
            } else {
                numTimesToHit = enemies.size();
            }

            for(int i = 0; i < numTimesToHit; i++) {
                Troll target = null;
                if(numTimesToHit >= 3) {
                    target = getRandomTarget(enemies); // Getting random targets for 3 enemies
                } else {
                    target = enemies.get(i); // Hitting each target if the num of enemies is less than 3
                }

                // Critical attack for the cleave
                if(!usedCritical) {
                    target.takeDamage(new Attack("", criticalHit, DamageType.PHYSICAL));
                    usedCritical = true;
                } else {
                    target.takeDamage(new Attack("", hits, DamageType.PHYSICAL)); 
                }
                removeVanquished(enemies, target); 

            }

        });

        abilities.put("Back Stab", (enemies, party) -> {
            int[] hits = {100};
            Troll target = getRandomTarget(enemies);
            target.takeDamage(new Attack("", hits, DamageType.POISON));
            removeVanquished(enemies, target);
        });

    }

    public Fighter(String name) {
        super(name, 150, abilities);
    }
    
    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("Cleave", hits, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 1.25;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 0.75;
        }
        takeDamage(attack, adjustment);
    }
}
