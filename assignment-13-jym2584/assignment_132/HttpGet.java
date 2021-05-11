package assignment_132;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpGet {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 8080);
        //InputStream input = socket.getInputStream();
       // OutputStream output = socket.getOutputStream();

        //send request
       // String request = "HTTP/1.1 200 OK\r\n"
       // + "Content-Length: 12\r\n"
       // + "Content-Type: text/plain; charset=utf-8\r\n\r\n"
        //+ "Hello World!\r\n";
        
        //output.write(request.getBytes());
        //output.flush();

        //System.out.println("flushed");
        //receive
        while(true) {
            byte[] buf = new byte[2048];
            int length = input.read(buf);
            if(length <= 0) {
                break;
            }
            String response = new String(buf, 0, length);
            System.out.println(response);
        }
        System.out.println("done");
        socket.close();
    }
    
}