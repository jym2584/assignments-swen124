import java.util.Scanner;

public class HelloWorld {
    
    public static void helloName(String first, String last) {
        System.out.println("Hello, " + first + " " + last);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String first = scanner.next();
        String last = scanner.next();


        helloName(first, last);
        scanner.close();
    }
}