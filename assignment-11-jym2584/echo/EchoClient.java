package echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket server = new Socket("localhost", 54321);
        PrintWriter out = new PrintWriter(server.getOutputStream());

        Scanner console = new Scanner(System.in);
        String message = console.nextLine();

        while(!message.equals("")) {
            out.println(message);
            out.flush();

            //Scanner in = new Scanner(server.getInputStream());
            //String response = in.nextLine();
            //System.out.println(response);
            
            message = console.nextLine();
        }

        console.close();
        server.close();
    }
}
