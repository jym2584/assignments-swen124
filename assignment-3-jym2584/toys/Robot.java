package toys;
/**
 * Robot child of Toy
 * @author Jin Moon
 */
public class Robot extends Toy {
    private int charge;
    private boolean randomSounds;
    String[] sound = {"BEEP BOOP. I AM A ROBOT.",
                "Shut up, baby I know it!", 
                "Is it possible - nay, probable - that my whole life is just a product of my or someone else's imagination?",
                "Hot diggity daffodil!",
                "I came to this planet with a simple dream of killing all humans",
                "Hey Sexy Mama... Wanna kill all humans?",
                "I'm going to build my own theme park! With blackjack! And hookers! You know what- forget the park!",
                "Oh, no room for me, huh? Fine! I’ll go build my own lunar lander, with blackjack and hookers. In fact, forget the lunar lander and the blackjack. Ahh, screw the whole thing!",
                };

    /**
     * Robot child of Toy
     * @param name name of the robot
     * @param productCode product code of the robot
     * @param msrp robot price 
     * @param randomSound true/false if we should allow the robot to make some random sounds
     */
    public Robot(String name, int productCode, double msrp, boolean randomSound) {
        super(name, productCode, msrp);
        this.charge = 100;
        this.randomSounds = randomSound;
    }

    /**
     * Always defaults the randomSound to false
     * @param name
     * @param productCode
     * @param msrp
     */
    public Robot(String name, int productCode, double msrp) {
        this(name, productCode, msrp, false);
    }

    /**
     * Charges the robot while preventing the charge to surpass 100
     * @param amount takes in the charge amount
     */
    protected void charge(int amount) {
        int chargeTemp = charge + amount;

        if (chargeTemp >= 100) {
            this.charge = 100;
            System.out.println(getName() + " says: BEEP BOOP. BATTERY OVERLOADED. I AM SUPER-SAIYAN. BEEP BOOP. (" + charge + "% charge)");
        } else {
            this.charge = chargeTemp;
            System.out.println(getName() + " says: BEEP BOOP. CHARGED UP TO " + charge + "%. BEEP BOOP.");
        }
    }

    /**
     * depletes 20 charge after playing with it.
     * Says a random quote if allowed
     */
    public void play() {
        if (charge == 0) {
            System.out.println(getName() + " doesn't seem to be playing anything. Maybe it's out of charge? (" + charge + "%)");
        } else {
            this.charge -= 20;

            System.out.print(getName() + " walks around in circles and says: \"");
            if (this.randomSounds) { // if the robot can play random sounds
                System.out.println(sound[randomNum(0,sound.length-1)] + "\"");
            } else {
                System.out.println(sound[0] + "\"");
            }

            System.out.println("  > Charge is now: " + charge + "%");



        }
    }

    public int getCharge() {
        return charge;
    }

    @Override
    public String toString() {
        return "Robot Toy{name= " + getName() + ", productCode= " + getProductCode() + ", msrp= " + getMsrp() + ", charge= " + charge + "%}";
    }

    public static void main(String[] args) {
        Robot myrobot = new Robot("beep boop", 1234567, 50.23, true);
        System.out.println(myrobot);
        myrobot.play();
        myrobot.play();
        myrobot.play();
        myrobot.play();
        myrobot.play();
        myrobot.play();
        myrobot.charge(100);

    }
}
