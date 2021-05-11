package tinychat.old;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import guessing.Duplexer;

public class TinyChatServerThread extends Duplexer implements Runnable {
    private Socket socket;
    public TinyChatServerThread (Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void run() {
        while(true) {
            String message = read();
            System.out.println("Received " + message);

            System.out.println("SENDING: " + message + " hi");
            send(message + " hi");
        }
    }


    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(12410);
        while (true){ 
            System.out.println("Waiting for a connection ...");
            Socket client = server.accept();
            TinyChatServerThread tinyChatClient = new TinyChatServerThread(client);
            System.out.println("Received connection...");
            new Thread(tinyChatClient).start();
        }
           

    }
}
