package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorServer {
    public static void main(String[] args) throws IOException {        
        List<calculator.BinaryOperation> OPERATIONS = new ArrayList<>(7);
        OPERATIONS.add (new calculator.Addition());
        OPERATIONS.add (new calculator.Subtraction());
        OPERATIONS.add (new calculator.Multiplication());
        OPERATIONS.add (new calculator.Division());
        OPERATIONS.add (new FloorDivision());
        OPERATIONS.add (new Exponent());
        Calculator calculator = new Calculator(OPERATIONS);

        DatagramSocket mailbox = new DatagramSocket(12400);
        String result = "";
        
        while(true) {
            byte[] in = new byte[1024];
            DatagramPacket incoming = new DatagramPacket(in, in.length);
            mailbox.receive(incoming);
            String input = new String(incoming.getData(), 0, incoming.getLength());
            System.out.println(String.format("%s:%s sent: %s", incoming.getAddress(), incoming.getPort(), input));
            // As long as the user keeps entering operations, keep doing math.
            String[] tokens = input.strip().split(" ");

            // Add the new operation to the old result to form 
            // a complete operation. I.E. result was 5, user entered
            // * 7, the new input would be "5 * 7".
            if(tokens.length == 2 && result.length() != 0) {
                input = result + " " + input;
                tokens = input.strip().split(" ");
            }
            
            if (tokens.length < 2) {
                result = "error bad request";
            } 
            else {
                // Parse the components
                try {
                    float operand1 = Float.parseFloat(tokens[0]);
                    float operand2 = Float.parseFloat(tokens[2]);
                    // Get the result as a String
                    result = "" + calculator.calculate(tokens[1], operand1, operand2);
                } catch (Exception e) {
                    // Uh-oh, something bad happened, record it as the result
                    if(input.equals("User closed program.")) {

                    } else {
                        result = "error " + e.getLocalizedMessage();
                    }
                }
            }

            // Let the user know the result.
            System.out.print ("Result: " + result + "\n");

            /**
             * If the response was a number, use that number as the first value
             * in a new binary operation. If it was anything else, expect
             * a new 3 piece binary operation.
             */
            try {
                if (Double.isNaN (Double.parseDouble(result))) {
                    throw new NumberFormatException ();
                }
            } catch (NumberFormatException nfe) { 
                // Didn't get a numberic response, throw away the result
                result = "";
                System.out.println ();
            }
            


            /** Echos response to client */
            byte[]out = result.getBytes();
            DatagramPacket outgoing = new DatagramPacket(out, out.length,
            incoming.getAddress(), incoming.getPort());

            mailbox.send(outgoing);
        }
        //mailbox.close();
    }
}
