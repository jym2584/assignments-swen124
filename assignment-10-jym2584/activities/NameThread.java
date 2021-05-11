package activities;

import java.util.*;


public class NameThread {

    private static final List<String> name = Arrays.asList("B", "r", "o","s","k","i","i");
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        for(i = 0; i < name.size(); i++) {
            Thread thread = new Thread(new Runnable(){

                @Override
                public void run() {
                    System.out.println(name.get(i));
                }
                
            });
            thread.start();
            Thread.sleep(5);
        }

    }
}