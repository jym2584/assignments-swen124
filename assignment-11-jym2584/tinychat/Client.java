package tinychat;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Client Thread class.
 * RUN THIS
 */
public class Client implements Runnable {
    /**
     * Client's name
     */
    private final String name;
    /**
     * Connection socket
     */
    private final Socket server;
    /**
     * If the client has left the server
     */
    private boolean leftServer;

    /**
     * Client constructor
     * @param name client's name
     */
    public Client(String name) throws IOException {
        server = new Socket("localhost", 12410);
        this.name = name;
        leftServer = false;
    }

    public Socket getServer() {
        return server;
    }

    public void closeServer() throws IOException {
        server.close();
    }

    public boolean leftServer() {
        return leftServer;
    }

    /**
     * Driver code
     */
    @Override
    public void run() {
        System.out.println(String.format("Welcome to TinyChat, %s!", name));

        try {
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            out.println(String.format("%s: CONNECTED", name)); 

            Scanner console = new Scanner(System.in);
            while(!leftServer) { // While the client has not left the server
                /* Grab message */
                String message = console.nextLine();

                String messageToLower = message.toLowerCase();
                /* Close everything */
                if(messageToLower.equals("quit")) {
                    out.println(String.format("%s: QUIT", name));
                    out.flush();
                    
                    console.close();
                    leftServer = true;
                    System.out.println("Disconnected from TinyChat.");
                    break;
                }
                
                /* Send response to server */
                out.println(String.format("%s: %s", name, message));
                out.flush();

                // had recieve response here originally
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchElementException nsee) {
            // Already left the server, cant read nextline
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) throws IOException {
        /* Initialization */
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = console.nextLine();

        Client client = new Client(name);
        Thread thread = new Thread(client);
        thread.start();

        /* Keep looking for responses from other clients as long as they're still connected*/
        Scanner in = new Scanner(client.getServer().getInputStream());
        while(!client.leftServer()){
            try {
                
                String response = in.nextLine(); // gets response from client
                String[] tokens = response.split(":");

                /*
                Prints the response if:
                    - Something is said
                    - The response doesn't come from the same person that's typing it
                */
                if(!tokens[1].equals(" ") && !tokens[0].equals(name)) {
                    System.out.println(response);
                }

            } catch (NoSuchElementException nsee) {
                // Squash bug that tries to catch the message if the client has already left the server
            }
        }

        /* Close everything once the client has left the server */
        in.close();
        console.close();
        client.closeServer();






        /* old spaghetti code DONT LOOK PLS */




        /*
        Socket server = new Socket("localhost", 12410);
        PrintWriter out = new PrintWriter(server.getOutputStream(), true);
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = console.nextLine();
        Client user = new Client(name);
        out.println(name + ": CONNECTED");
        
        //out.flush();

        while(true) {
            String message = console.nextLine();
            if(message.equals("quit")) {
                out.println(user.getName() + ": QUIT");
                out.flush();
                break;
            }

            out.println(String.format("%s: %s", user.getName(), message));
            out.flush();




            //Scanner in = new Scanner(server.getInputStream());
            //String response = in.nextLine();
            //System.out.println(response);
        }

        console.close();
        server.close();
        */
    }
}
