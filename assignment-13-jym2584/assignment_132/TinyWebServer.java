package assignment_132;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.*;

public class TinyWebServer extends Thread {
    private final Socket client;
    
    public TinyWebServer(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() {
        try {
            OutputStream output = client.getOutputStream();
            
            String request = "HTTP/1.1 200 OK\r\n"
            + "Content-Length: 12\r\n"
            + "Content-Type: text/plain; charset=utf-8\r\n\r\n"
            + "Hello World!\r\n";
            
            output.write(request.getBytes());
            output.flush();
            
            output.close();
            client.close();
        } catch(Exception e){}
    }
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        while(true) {
            System.out.println("Waiting for connection...");
            Socket client = server.accept();
            System.out.println("Connection received");

            TinyWebServer webServer = new TinyWebServer(client);
            webServer.start();
        }

    }
}
