package toys;
/**
 * ActionFigure subclass from Doll subclass (that also is a child of the Toy class)
 * @author Jin Moon
 */
public class ActionFigure extends Doll {
    private boolean hasGrip;
    String[] actionPhrases = {"HIYAAH!",
                    "WAPOW!",
                "KARATE KICK!",
                "FALCON PUNCH!",
                "The fight is on!"};

    /**
     * ActionFigure subclass from Doll subclass (that also is a child of the Toy class)
     * @param name takes in a name
     * @param productCode product code
     * @param msrp the price
     * @param hairColor hair color
     * @param eyeColor eyecolor
     * @param hasGrip if the actionfigure has a kung fu grip or something
     */
    public ActionFigure(String name, int productCode, double msrp, String hairColor, String eyeColor, boolean hasGrip) {
        super(name, productCode, msrp, hairColor, eyeColor);
        this.hasGrip = hasGrip;
    }

    public ActionFigure(String name, int productCode, double msrp, String hairColor, String eyeColor) {
        this(name, productCode, msrp, hairColor, eyeColor, false);
    }

    /**
     * Checks if the doll has been fully used up before playing with it.
     * The doll also brandishes a sword if they have the kung fu grip
     */
    @Override
    public void play() {
        if (useDoll()) {
            System.out.println("You pulled the string. " + name + " says: \"" + actionPhrases[randomNum(0,actionPhrases.length-1)] + "\"");
            if (hasGrip) {
                System.out.println(name + " also brandishes a sword!");
            }

            System.out.println("  > Uses: " + getUses());
        }
    }

    public boolean grip() { return hasGrip; }

    @Override
    public String toString() {
        return "ActionFigure Toy{name= " + getName() + ", productCode= " + getProductCode() + ", msrp= " + getMsrp() 
        + ",\n         hairColor= " + getHairColor() + ", eyeColor= " + getEyeColor() + ", uses= " + getUses()
        + ",\n         hasGrip= " + hasGrip +"}";
    }

    public static void main(String[] args) {
        ActionFigure mydoll = new ActionFigure("Peter Chan", 1234567, 50.23, "blue", "red", true);
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
    }
}
