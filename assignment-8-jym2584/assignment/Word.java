package assignment;
import graphs.*;

public class Word {
    public static void main(String[] args) {
        WGraph<Character> graph = new WAdjacencyGraph<>();

        String my_word = "FortniTe";

        // Adding the characters to the graph
        graph.add(my_word.charAt(0));
        for(int i = 0; i < my_word.length(); i++) {
            graph.add(my_word.charAt(i));
        }

        // Connecting each point to 3 vertexes
        for (int i = 0; i < my_word.length() - 3; i++) {
            for(int j = i + 1; j < i + 4; j++) {
                double weight = Math.pow(i, 2)+53;
                graph.connect(my_word.charAt(i), my_word.charAt(j), weight);
            }
        }

        // Connecting them again
        for(int i = 1; i < my_word.length(); i++) {
            graph.connect(my_word.charAt(i-1), my_word.charAt(i), i);
        }
        // Connect first to last
        graph.connect(my_word.charAt(0), my_word.charAt(my_word.length()-1), Math.pow(my_word.length(),2));

        // Printsss
        System.out.println(graph.dijkstrasPath(my_word.charAt(0), my_word.charAt(my_word.length()-1)));

    }
}
