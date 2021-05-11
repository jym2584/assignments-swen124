package activities;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SearchPrinter {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.rit.edu");
        URLConnection connect = url.openConnection();
        connect.connect();
        Scanner in = new Scanner(connect.getInputStream());
        while(in.hasNextLine()) {
            System.out.println(in.nextLine());
        }

        in.close();
    }
}
