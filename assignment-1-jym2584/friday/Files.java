import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Files {
    public static void printFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fr);

        String line = reader.readLine();

        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }

        reader.close();
        fr.close();
    }

    public static void main(String[] args) {
        try {
            printFile("data/alice.txt");
        } catch (IOException e) {
            System.out.println("Cannot open file");
        }
    }
}
