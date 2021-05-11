package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import graphs.*;

/**
 * Reads from the file and connects the vertexes
 * 
 */


public class GraphReader<E> {

    /**
     * Reads from a file to connect the verticies to each other
     * @param filename 
     * @return returns the Map
     * @throws IOException if the file is invalid
     */
    public static Graph<String> readGraph(String filename) throws IOException {
        //System.out.println("Reading " + filename + "...");
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        Graph<String> graph = new AdjacencyGraph<>();
        String line = br.readLine(); // Skipping the first commented line
        line = br.readLine(); // Skipping the second commented line

        boolean noEndOfFile = true;
        while(noEndOfFile) {
            line = br.readLine(); // Reading from the third line forward
            if(line == null) {
                noEndOfFile = false; // If no lines can be read 
            } else {
                String[] tokens = line.split(" ");
                graph.add(tokens[0]); // Add the first token
                //System.out.println("**Added " + tokens[0] + " to our graph ----------------------------------------------> graph.add(" + tokens[0] + ") ");
                
                for(int i = 1; i < tokens.length; i++) {
                    if(!graph.contains(tokens[i])) { // If the other values beyond token0 doesn't already exist
                        graph.add(tokens[i]); // Create them
                        //System.out.println("Added new vertex " + tokens[i] + " to our graph since it had never existed ----------> graph.add(" + tokens[i] + ") ");
                    }
                }

                for (int j = 1; j < tokens.length; j++) {
                    graph.connectUndirected(tokens[0], tokens[j]); // And connect them
                   // System.out.println("Connected " + tokens[j] + " to " + tokens[0] + " via method connectUndirected -----------------------> graph.connectUndirected(" + tokens[0] + ", " + tokens[j] + ") ");
                }
            }


            //System.out.println();
        }

        fr.close();
        br.close();

        System.out.println(filename + " connected components: " + graph.countConnectedComponents());
        return graph;
    }
    public static void main(String[] args) {
        try {
            Graph<String> mygraph = readGraph("data/k2_2.txt");
            System.out.println("Counted components " + mygraph.countConnectedComponents());

        } catch (IOException ioe) {
            System.out.println("One or more files cannot be read.");
        }
    }
}
