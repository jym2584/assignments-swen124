package tinychat.old;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import java.util.Scanner;

import guessing.Duplexer;

public class TinyChatClientThread extends Duplexer implements Runnable {
    private Socket socket;
    private List<TinyChatClientThread> clientThreads;
    
    public TinyChatClientThread(Socket socket, List<TinyChatClientThread> clientThreads) throws IOException {
        super(socket);
        this.clientThreads = clientThreads;
    }
    @Override
    public void run() {
        try {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


        Scanner console = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = console.nextLine();

        /** Lets all the other threads that someone connected to the server */
        synchronized(this) {
            for(TinyChatClientThread client: clientThreads) {
                out.println(name + " CONNECTED.");
            }
        }

        while(true) {
            String message = console.nextLine();

            /**
             * Prints the message to the other threads
             */
            synchronized(this) {
                for(TinyChatClientThread client: clientThreads) {
                    if(client != this) {
                        out.println(String.format("%s: %s", name, message));
                        out.flush();
                    }
                }
            }
        }

        } catch (IOException e) {}





    }

    public static void main(String[] args) throws IOException {
        TinyChatClientThread[] clientThreads = new TinyChatClientThread[20];
        Socket server = new Socket("localhost", 12410);
        TinyChatClientThread client = new TinyChatClientThread(server, clientThreads);
        new Thread(client).start();
    }
    
}
