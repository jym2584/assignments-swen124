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

    public static void main(String[] args) {
        float result = add(5, 8);
        result = multiply(result, 2);
        System.out.println("Result = " + result);
    }
}
