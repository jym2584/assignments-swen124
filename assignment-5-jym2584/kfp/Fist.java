package kfp;

import java.util.Arrays;
import java.util.Random;

public class Fist{
    private final int damage = 1000;

    public <T> Fist(){
        // empty
    }
    
    @Override
    public String toString(){
        return "Fist dealing damage!" + damage;
    }

    public int[] combo(){
        Random r = new Random();
        int n = r.nextInt(10) + 1;
        int[] a = new int[n];
        Arrays.fill(a, damage);
        return a;

    }
}
