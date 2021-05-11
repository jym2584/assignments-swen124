package question2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import backtracker.Backtracker;
import backtracker.Configuration;

// Delete for Exam, but concept credit goes to Ahmed

public class GameShow implements Configuration {
    private Set<Prize> prizes;
    private int priceTarget; 
    private Set<Prize> basket;

    /**
     * Creates a new GameShow object with an empty basket
     * @param prizes - initial set of prizes
     * @param priceTarget - the total price target the prizes should add up to
     */
    public GameShow(Set<Prize> prizes,int priceTarget) {
        this(prizes,priceTarget,new HashSet<Prize>());
    }
    
    /**
     * Creates a new GameShow object
     * @param prizes - set of prizes remaining
     * @param priceTarget - the total price target the prizes should add up to
     * @param basket - a basket containing zero or more prizes
     */
    private GameShow(Set<Prize> prizes,int priceTarget, Set<Prize> basket) {
        this.prizes = prizes;
        this.priceTarget = priceTarget;
        this.basket = basket;
    }

    /**
     * Calculates the price total of prizes in the basket set
     * @return - the total price of all prizes in basket, 0 if the basket is empty
     */
    private int getBasketPriceTotal() {
        int total = 0;
        for(Prize item: basket) {
            total += item.getPrice(); 
        }
        return total;
    }

    /**
     * Generates a collection of successors (solution candidates)
     * @return - collection of successors
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();
        for(Prize prize : prizes) {
            Set<Prize> basketCopy = new HashSet<>(basket);
            Set<Prize> prizeCopy = new HashSet<>(prizes);
            
            basketCopy.add(prize);
            successors.add(new GameShow(prizeCopy, priceTarget, basketCopy));
            
            prizeCopy.remove(prize);
        }

        return successors;
    }

    /**
     * Determines whether a configuration is valid
     * @return - true if the configuration is valid, false otherwise
     */
    public boolean isValid() {
        if (basket.isEmpty()) {
            return true;
        }

        if (getBasketPriceTotal() <= priceTarget) {
            return true;
        }

        return false;
    }

    /**
     * Determines if this configuration meets the Goal criteria
     * @return - true if the Goal criteria is met, false otherwise
     */
    @Override
    public boolean isGoal() {
        if((getBasketPriceTotal() == priceTarget) && isValid()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Basket:{" + getBasketPriceTotal() + ", " + basket + "}";
    }

    /**
     * Helper method
     */
    public static void giveItATry(int priceTarget) {
        GameShow gameShow = new GameShow(Prize.createSet(), priceTarget);
        Backtracker backtracker = new Backtracker(false);
        Configuration solution = backtracker.solve(gameShow);
        if (solution != null)
            System.out.println(solution + "\n");
        else
            System.out.println("No solution found");
    }
    
    public static void main(String[] args) {
        GameShow gameShow = new GameShow(Prize.createSet(), 32);
        for(Configuration config: gameShow.getSuccessors()) {
            System.out.println(config);
        }
        // Should produce a solution
        giveItATry(32);

        // Should produce a solution
        giveItATry(700);

        // Should NOT produce a solution
        giveItATry(6);
    }   
}
