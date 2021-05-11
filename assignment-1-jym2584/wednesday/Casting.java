public class Casting {
    public static void main(String[] args) {
        int a = 1234567;
        long b = a;
        System.out.println(a + " " + b);

        long c = 31002003001;
        int d = (int)c;
        System.out.println(c + " " + d);

        int e = 67;
        char f = (char)e;

        System.out.println(e + " " + f);
    }
}
