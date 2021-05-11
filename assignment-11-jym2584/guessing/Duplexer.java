package guessing;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Duplexer {
    private Socket sock;
    private Scanner in;
    private PrintWriter out;

    public Duplexer (Socket sock) throws IOException{
        this.sock = sock;
        in = new Scanner(sock.getInputStream());
        out = new PrintWriter(sock.getOutputStream());
    }

    public void send (String message) {
        out.println(message);
        out.flush();
    }

    public String read () {
        return in.nextLine();
    }

    public void close (){
        in.close();
        out.close();
        try {
            sock.close();
        } catch (IOException e) {}
    }
}
