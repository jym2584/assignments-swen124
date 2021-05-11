package chevre;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClubChevre club = new ClubChevre();
        TrollBouncer troll = new TrollBouncer(club);
        Thread trollThread = new Thread(troll);
        trollThread.start();

        for(int i = 0; i < 10; i++) {
            Goat goat = new Goat(club);
            Thread t1 = new Thread(goat);
            t1.start();
            Thread.sleep(Utils.getRandomNumber(0, 1000));
        }
    }
}
