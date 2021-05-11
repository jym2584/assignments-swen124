package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPEchoServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket mailbox = new DatagramSocket(54321);
        while(true) {
            byte[] in = new byte[1024];
            DatagramPacket incoming = new DatagramPacket(in, in.length);
            mailbox.receive(incoming);
            String message = new String(incoming.getData(), 0, incoming.getLength());
            System.out.println(message);
            

            byte[]out = message.getBytes();
            DatagramPacket outgoing = new DatagramPacket(out, out.length,
            incoming.getAddress(), incoming.getPort());

            mailbox.send(outgoing);
        }
        //mailbox.close();
    }
}
