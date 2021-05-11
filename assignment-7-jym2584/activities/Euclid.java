package activities;

public class Euclid {
    public static int gcd (int a, int b) {
    while (a != b) {
        if (a > b) {
            a = a - b;
        }
        else {
            b = b - a;
        }
    }
    return a; 
    }

    public static void main(String[] args) {
        System.out.println(gcd (160, 64));
        System.out.println(gcd (13, 75));
    }
}