package tinychat;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
/**
 * TinyChatClient no Threads
 * Single connection
 */
public class TinyChatClient {
    private final String name;
    public TinyChatClient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws IOException {

        Socket server = new Socket("localhost", 12410);
        PrintWriter out = new PrintWriter(server.getOutputStream(), true);

        Scanner console = new Scanner(System.in);

        System.out.print("Enter a name: ");
        String name = console.nextLine();
        TinyChatClient user = new TinyChatClient(name);
        out.println(user.getName() + ": CONNECTED");
        //out.flush();
        
        System.out.println("Welcome to TinyChat, " + name + "!");

        while(true) {
            String message = console.nextLine();
            
            String messageToLower = message.toLowerCase();
            if(messageToLower.equals("quit")) {
                out.println(user.getName() + ": Quitted");
                out.flush();
                break;
            }

            out.println(String.format("%s: %s", user.getName(), message));
            out.flush();




            //Scanner in = new Scanner(server.getInputStream());
            //String response = in.nextLine();
            //System.out.println(response);
        }
        System.out.println("Goodbye!");
        console.close();
        server.close();
    }
}
