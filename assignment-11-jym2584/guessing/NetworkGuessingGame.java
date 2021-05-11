package guessing;

import java.io.IOException;
import java.net.Socket;

public class NetworkGuessingGame {
    public static void main(String[] args) throws IOException {
        //make a guessing game
        Socket server = new Socket("loalhost", 12345);
        GuessingGame game = new GuessingGameProxy(server);
        //use a game player to play it
        GamePlayer player = new GamePlayer(game);
        player.playTheGame();
    }
}
