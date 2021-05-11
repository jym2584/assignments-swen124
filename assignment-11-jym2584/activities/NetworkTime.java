package activities;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class NetworkTime {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("time.nist.gov", 13);
        Scanner in = new Scanner(sock.getInputStream());
        while(in.hasNext()) {
            System.out.print(in.next() + " ");
        }
        System.out.println();
        in.close();
        sock.close();
    }
}
