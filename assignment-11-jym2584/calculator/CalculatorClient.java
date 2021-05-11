package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket mailbox = new DatagramSocket(); // don't care about port, automatically picks free port
        byte[] in = new byte[1024];

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print ("Enter math operation (or nothing to exit): ");
            String getInput = scanner.nextLine();
            if(getInput.equals("")) {
                System.out.println("Quitting...");

                byte[] quit = "User closed program.".getBytes();
                DatagramPacket sendQuitToServer = new DatagramPacket(quit, quit.length, 
                InetAddress.getLocalHost(), 12400);
                mailbox.send(sendQuitToServer);

                mailbox.close();
                break;
            }
    
            byte[] out = getInput.getBytes();
            DatagramPacket outgoing = new DatagramPacket(out, out.length, 
                                                InetAddress.getLocalHost(), 12400);


        mailbox.send(outgoing);

        /**Echos response sent to server */
        DatagramPacket incoming = new DatagramPacket(in, in.length);
        mailbox.receive(incoming);
        String response = new String(incoming.getData(), 0, incoming.getLength());
        System.out.println(String.format("Response from server (to client %s:%s): %s", incoming.getAddress(), incoming.getPort(), response));

        }
        mailbox.close();
    }
}
