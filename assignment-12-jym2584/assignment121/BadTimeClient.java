package assignment121;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
public class BadTimeClient {
    public static void main(String[] args) throws IOException {
        Socket server = new Socket("localhost", 13000);
        PrintWriter out = new PrintWriter(server.getOutputStream());

        //Scanner console = new Scanner(System.in);
        //String message = console.nextLine();

        while(true) {
            // send response to server
            out.println("something nice");
            out.flush();

            // get response from server
            Scanner in = new Scanner(server.getInputStream());
            String response = in.nextLine();
            System.out.println(response);
            
            String[] tokens = response.split(":");
            
            if(tokens[0].equals("ERROR")) {
                //console.close();
                server.close();
                System.out.println("Bad things happened so we left the server.");
                break;
            }

            //message = console.nextLine();
        }
    }
}
