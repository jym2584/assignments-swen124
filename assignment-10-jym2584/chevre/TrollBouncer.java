package chevre;

public class TrollBouncer implements Runnable{
    private final ClubChevre club;

    public TrollBouncer(ClubChevre c) {
        club = c;
    }
    

    @Override
    public void run() {
        while(true) {
            synchronized(club) {
                //if there is room in club and goats in line
                while(!club.isAtCapacity() && club.numberOfGoatsInLine() > 0) {
                    //choose next goat and remove it from line
                    Goat goat = chooseGoat();
                    club.removeGoatFromLine(goat);
                    club.startDancing(goat);
                    System.out.println("The Troll Bouncer lets " + goat.getName() + " into the club. There are now " + club.numberOfDancingGoats() + " on the dance floor.");

                    //notify goat it's been picked
                    synchronized(goat) {
                        goat.notify();
                    }

                    //the club is full or line empty so wait for another
                    try {
                        club.wait();
                    } catch(InterruptedException e) {}
                }
            }
        }
        
    }


    private Goat chooseGoat() {
        Goat chosen = null;
        double best = 0;

        double length = club.numberOfGoatsInLine();
        for(double pos=0; pos<length; pos++) {
            Goat candidate = club.getGoatAtPosition((int) pos);
            double score = length / (pos + 1) * candidate.getCoolness();
            if(score > best) {
                best = score;
                chosen = candidate;
            }
        }
        return chosen;
    }
    
}
