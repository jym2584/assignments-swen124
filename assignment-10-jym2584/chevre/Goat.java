package chevre;

import java.util.Random;

public class Goat implements Runnable{
    private final String name;
    private final int coolness;
    private final int stamina;
    private final ClubChevre club;

    public Goat(ClubChevre c) {
        name = Utils.makeGoatName();
        coolness = Utils.getRandomNumber(1, 100);
        stamina = Utils.getRandomNumber(5, 10);
        club = c;
    }

    public String getName() {
        return name;
    }

    public int getCoolness() {
        return coolness;
    }

    @Override
    public void run() {
        synchronized(this) {
            //get in line
            synchronized(club) {
                club.getInLine(this);
                System.out.println(name + " is getting in line behind " + (club.numberOfGoatsInLine()-1) + " other goats.");
                club.notify();
            }

            //wait to be picked
            try{ 
                this.wait();
            } catch(InterruptedException e){}

            //dance
            for(int i=0; i<stamina; i++) {
                System.out.println(name + " is dancing!");
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){}
            }

            synchronized(club) {
                club.stopDancing(this);
                System.out.println(name + " is exhausted and heads home.");
                club.notify();
            }
        }
    }

    
}
