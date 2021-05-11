public class Basics {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) { // or i += 1, ++i
            if (i % 3 == 0 ^ i % 7 == 0) { // ^ = xor. One or the other, but not both
                System.out.print(i + " ");
            }
        }
    }
        
}
