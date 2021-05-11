package data;
import graphs.*;
import java.io.IOException;
/**
 * Counting connected components on files for data/*
 */
public class Main {
    public static void main(String[] args) {
        try {
            GraphReader.readGraph("data/a_13_5.txt");
            GraphReader.readGraph("data/a_22_3.txt");
            GraphReader.readGraph("data/a_26_4.txt");
            GraphReader.readGraph("data/a_6_1.txt");
            GraphReader.readGraph("data/a_7_3.txt");
            GraphReader.readGraph("data/bipartite.txt");
            GraphReader.readGraph("data/k2.txt");
            GraphReader.readGraph("data/k2_2.txt");
            GraphReader.readGraph("data/k3.txt");
            GraphReader.readGraph("data/k3_3.txt");
            GraphReader.readGraph("data/k4.txt");
            GraphReader.readGraph("data/k5.txt");
            GraphReader.readGraph("data/non_bipartite.txt");
            GraphReader.readGraph("data/v2.txt");

        } catch (IOException ioe) {
            System.out.println("One or more files cannot be read.");
        }
    }
}
