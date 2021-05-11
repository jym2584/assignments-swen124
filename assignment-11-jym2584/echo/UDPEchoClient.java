package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public UDPEchoClient(String text) throws IOException {
        DatagramSocket mailbox = new DatagramSocket(); // don't care about port, automatically picks free port
        
        int count = 0;
        byte[] in = new byte[1024];
        while(true) {
            String message = count + ": " + text;
            byte[] out = message.getBytes();
            DatagramPacket outgoing = new DatagramPacket(out, out.length, 
                                                InetAddress.getLocalHost(), 54321);


            mailbox.send(outgoing);

            DatagramPacket incoming = new DatagramPacket(in, in.length);
            mailbox.receive(incoming);
            String response = new String(incoming.getData(), 0, incoming.getLength());
            System.out.println(response);

            count++;

        }
        //mailbox.close();
    }

    public static void main(String[] args) throws IOException {
        new Thread ( () -> {
            try {
            new UDPEchoClient("Hello");
            } catch (IOException ioe) {}
        }).start();

        new Thread ( () -> {
            try {
            new UDPEchoClient("Bye");
            } catch (IOException ioe) {}
        }).start();

    }
}
