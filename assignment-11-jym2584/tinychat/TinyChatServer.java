package tinychat;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * TinyChatServer no Threads
 * Single connection
 */
public class TinyChatServer {
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12410);
        System.out.println("Waiting for connection");
        Socket client = server.accept();
        Scanner in = new Scanner(client.getInputStream());
        while(true) {
            try {
                String message = in.nextLine();
                System.out.println(message);
            
            } catch (NoSuchElementException nsee) {
                // Client left server
            }




            
            //PrintWriter out = new PrintWriter(client.getOutputStream());
            //out.println("SERVER SENT: " + message);
            //out.flush();
        }

        //in.close();
        //client.close();
        //server.close();

    }
}
