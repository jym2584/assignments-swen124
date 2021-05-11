package part2;

public class Bridge {
    /**
     * If someone has crossed the bridge, make this true
     * Flips it back to false if someone leaves the bridge
     */

    private boolean crossed;

    public Bridge() {
        crossed = false;
    }

    /**
     * Woolie entering the bridge
     * If they are already crossing the bridge, then wait for the thread to finish
     */
    public void enterBridge() {
        while(crossed){
            try {
                Thread.sleep(10); // Makes the thread 'wait' before starting the next thread
                //this.wait();
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
        crossed = true;
    }

    /**
     * Flips crossed back to false, meaning they left the bridge
     */
    public void leaveBridge() {
        crossed = false;
        //this.notify();
    }
}