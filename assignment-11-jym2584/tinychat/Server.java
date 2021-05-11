package tinychat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Server thread class
 * RUN THIS
 */
public class Server extends Duplexer implements Runnable {
    /**
     * Client socket
     */
    private Socket socket;
    /**
     * List of clients
     */
    private List<Socket> clients;

    /**
     * Server constructor
     * @param socket client socket
     * @param clients list of clinet sockets
     * @throws IOException something
     */
    public Server(Socket socket, List<Socket> clients) throws IOException {
        super(socket);
        this.clients = clients;
    }

    public Socket getSocket() {
        return socket;
    }

    /**
     * Driver code
     */
    @Override
    public void run() {
        while(true) {
            try {
                String message = "";
                message = read(); // get message
                
                String[] tokens = message.split(":");
                if(tokens[1].equals(" QUIT")) {
                    System.out.println("Recieved Quit from client " + tokens[0]);
                    close();
                
                } else {
                    System.out.println(message + " (recieved from client)");
                }

                /** Sends the recieved message to all clients */
                for(Socket client: clients) {
                    try {

                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                        out.println(message);
                        out.flush();
                    } catch (IOException e) {}

                }

            } catch (NoSuchElementException nsee) {
                // Client left the server
            } catch (IllegalStateException ise) {
                // Client left the server
            }
        }
    }


    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(12410);
        List<Socket> clients = new ArrayList<>();

        while (true){ 
            System.out.println("Waiting for a connection...");
            Socket client = server.accept();
            Server tinyChatClient = new Server(client, clients);
            clients.add(client);

            System.out.println(String.format("Received incoming connection from %s:%s", client.getLocalAddress(), client.getPort()));

            new Thread(tinyChatClient).start();
        }
           

    }
}
