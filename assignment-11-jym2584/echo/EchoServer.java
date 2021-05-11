package echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        while(true) {
            Socket client = server.accept();
            Scanner in = new Scanner(client.getInputStream());
            String message = in.nextLine();
            System.out.println(message);


            PrintWriter out = new PrintWriter(client.getOutputStream());
            out.println(message);
            out.flush();
        }

        //in.close();
        //client.close();
        //server.close();

    }
}
