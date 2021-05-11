package question2;

import java.util.HashSet;
import java.util.Set;

public enum Prize {
    TV(300),
    GUM(2),
    LAPTOP(700),
    TOASTER_OVEN(30),
    VR_HEADSET(300),
    DETERGENT(12),
    MICROWAVE(80),
    BIKE(150),
    RICE_A_RONI(1),
    TURTLE_WAX(7),
    KEURIG(200),
    CHAIR(15),
    MOUSE(10),
    LUGGAGE(80),
    THROW_RUG(20);


    private int price;
    private Prize(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name() + ":" + price;
    }
    public static Set<Prize> createSet() {
        Set<Prize> prizes = new HashSet<>();
        for (Prize prize : Prize.values())
            prizes.add(prize);
        return prizes;
    }
}
