package toys;
/**
 * Doll child from Toy
 * @author Jin Moon
 */
public class Doll extends Toy {
    private String hairColor;
    private String eyeColor;
    private int uses;
    String[] sayings = {"People said I was dumb, but I proved them.",
                    "I finally found what I need to be happy and it's not friends, it's things.",
                "Good news, everyone! I've taught the toaster to feel love!",
                "Fix it,fix it, fix it,fix it!",
                "Hey wait, I'm having one of those things. You know, a headache with pictures."};
    
    /**
     * Doll child from Toy
     * @param name name for the doll
     * @param productCode doll's product code
     * @param msrp the price
     * @param hairColor doll's hair color
     * @param eyeColor the eye color of the doll
     */
    public Doll(String name, int productCode, double msrp, String hairColor, String eyeColor) {
        super(name, productCode, msrp);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.uses = 10;
    }

    /**
     * Checks if the doll has been fully used up before playing with it
     * Also says a random quote from the list of arrays.
     */
    public void play() {
        if (useDoll()) {
            System.out.println("You pulled the string. " + name + " says: \"" + sayings[randomNum(0,sayings.length-1)] + "\"");
            System.out.println("  > Uses: " + uses);
        }
    }


    public int getUses() {return uses;}
    public String getHairColor() {return hairColor;}
    public String getEyeColor() {return eyeColor;}

    /**
     * Our helper function to play with the doll
     * @return
     */
    public boolean useDoll(){
        if (uses == 0) {
            System.out.println(name + " seems to be broken :(");
            return false;
        } else {
            uses -= 1;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Doll Toy{name= " + getName() + ", productCode= " + getProductCode() + ", msrp= " + getMsrp() + ", hairColor= " + hairColor + ", eyeColor= " + eyeColor + ", uses= " + uses +"}";
    }

    public static void main(String[] args) {
        Doll mydoll = new Doll("beep boop", 1234567, 50.23, "blue", "red");
        System.out.println(mydoll);
        mydoll.play();
        mydoll.play();
        mydoll.play();
        mydoll.play();
        mydoll.play();
        mydoll.play();
        mydoll.play();
        mydoll.play();
        mydoll.play();
        mydoll.play();
        mydoll.play();
        mydoll.play();
        mydoll.play();

    }
}
