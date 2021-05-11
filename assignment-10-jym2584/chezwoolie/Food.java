package chezwoolie;

/**
 * Food class
 */
public class Food {
    private final String name;
    private final int servings;
    
    /**
     * Food class
     * @param name name of the food
     * @param servings number of servings
     */
    public Food(String name, int servings) {
        this.name = name;
        this.servings = servings;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return servings + " servings of " + name;
    }

    public int getServings() {
        return servings;
    }
}
