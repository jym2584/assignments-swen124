import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculon {

    public static float add (float left, float right) {
        return left + right;
    }

    public static float subtract (float left, float right) {
        return left - right;
    }

    public static float multiply (float left, float right) {
        return left * right;
    }

    public static float divide (float left, float right) {
        return left / right;
    }
    
    public static float raise (float base, float exponent) {
        float result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an x and y: ");
        try {
            float x = input.nextFloat();
            float y = input.nextFloat();
            float add = add(x, y);
            float subtract = subtract(x, y);
            float multiply = multiply(x, y);
            float divide = divide(x, y);
            float result = raise(x, y);
            System.out.println("Result Add = " + add);
            System.out.println("Result Subtract = " + subtract);
            System.out.println("Result Multiply = " + multiply);
            System.out.println("Result Divide = " + divide);
            System.out.println("Result Raise = " + result);
        } catch (InputMismatchException ime) {
            System.out.println("Not a valid integer");
        }
        input.close();
    }
}
