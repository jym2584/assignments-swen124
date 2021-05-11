package guessing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GuessingGameServer extends Duplexer implements Runnable{
    GuessingGame game;

    public GuessingGameServer(Socket sock) throws IOException {
        super(sock);
        game = new GuessingGameImpl();
    }

    public void run(){
        boolean keepRunning = true;
        while (keepRunning) {
            String message = read();
            String response;
            System.out.println("RECEIVED: " + message);
            String[] tokens = message.split(" ");
            switch(tokens[0]){
                case "RESTART":
                    game.restart();
                    response = "RESTARTED";
                break;
                case "QUIT":
                    game.quit();
                    keepRunning = false;
                    response = "GAME_OVER";
                break;
                case "GUESS":
                   GuessResult result = game.guess(Integer.parseInt(tokens[1]));
                   response = result.toString();
                break;
                default:
                    response = "ERROR";
                break;
            }
            System.out.println("SENDING: " + response);
            send(response);
        }
        close();
    }

    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(12345);
        while (true){ 
            System.out.println("Waiting for a connection ...");
            Socket client = server.accept();
            GuessingGameServer gameServer = new GuessingGameServer(client);
            System.out.println("Starting the game server ...");
            new Thread(gameServer).start();
        }
           

    }
}
