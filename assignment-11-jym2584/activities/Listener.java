package activities;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Listener {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12347);
        Socket client = server.accept();

        Scanner in = new Scanner(client.getInputStream());
        String message = in.nextLine();
        System.out.println(message);

        in.close();
        server.close();
        client.close();

    }
}
