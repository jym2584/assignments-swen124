package activities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("data/alice.txt");
        BufferedReader reader = new BufferedReader(file);
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}