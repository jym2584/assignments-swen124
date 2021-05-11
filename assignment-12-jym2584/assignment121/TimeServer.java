package assignment121;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class TimeServer extends Thread {
    private final Socket client;

    public TimeServer(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                // get response from client
                Scanner in = new Scanner(client.getInputStream());
                String message = in.nextLine();
                System.out.println(String.format("%s:%s response: %s", client.getLocalAddress(), client.getPort(), message));

                // sending responses to client
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                if(message.equals("TIME")) {
                    Date date = new Date();
                    out.println(date.toString());
                    out.flush();
                } else {
                    out.println("ERROR: Unknown request: " + message);
                    out.flush();
                }
                
                client.close();

            } catch (Exception e) {
                // squash
            } 
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(13000);

        // should handle sequential clients?
        while(true) {
            System.out.println("Waiting for a connection...");
            Socket client = server.accept();
            System.out.println(String.format("Recieved incoming connection from %s:%s", client.getLocalAddress(), client.getPort()));
            
            TimeServer timeServer = new TimeServer(client);
            timeServer.start();
        }
    }
    
}
