package activities;

import java.rmi.server.Operation;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {
    public interface Operation {
        double execute(double left, double right);
    }

    public static Operation gOperation(String operator) {
        if(operator.equals("+")) {
            return new Operation() {

                @Override
                public double execute(double left, double right) {
                    return left + right;
                }
                
            };
        }

        if(operator.equals("-")) {
            return (left, right) -> {
            return left - right;
            };
        }

        else if(operator.equals("*")) {
            return (left, right) -> left * right;
        }

        else if(operator.equals("/")) {
            return (left, right) -> left / right;
        }

        else if(operator.equals("^")) {
            return Math::pow;
        }

        throw new UnsupportedOperationException(operator + " is not supported");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Double left = 0.0;
        Double right = 0.0;
        String op = null;

        System.out.println("Welcome to simple calculator");
        while(true) {
            try {
                left = in.nextDouble();
                op = in.next();
                right = in.nextDouble();
                Operation math = gOperation(op);
                System.out.println(String.format("%f %s %f = %f", left, op, right, math.execute(left, right)));
            
                
            } catch (InputMismatchException ime) {
                break;
            } catch (NoSuchElementException nsee) {
                break;
            }
        }
        System.out.println("bye");
        in.close();
    }
}
