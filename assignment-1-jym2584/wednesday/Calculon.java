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
        float result = raise(2, 8);
        System.out.println("Result = " + result);
    }
}
