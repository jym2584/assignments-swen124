package activities;

import java.io.IOException;
import java.net.InetAddress;

public class PrintHostINfo {
    public static void main(String[] args) throws IOException {
        InetAddress me = InetAddress.getLocalHost();
        System.out.println(me.getHostAddress());
        System.out.println(me.getHostName());
        System.out.println(me.getLoopbackAddress());
    }
}

