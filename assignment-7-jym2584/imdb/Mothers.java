package imdb;
import java.util.*;
import graphs.*;

public class Mothers {
    public static List<String> findMothers(Graph<String> graph, List<String> values) {
        List<String> mothers = new ArrayList<>();

        for(String value: values) {
            int count = 0;
            for(String value_2: values) {
                //System.out.println(value + " to " + value_2 +  ": " + graph.bfPath(value, value_2));
                if(graph.bfPath(value, value_2) != null) { // if the path exists
                    count++;
                    //System.out.println(                       value + " to " + value_2 + " count: " + count);
                }
                if(count == values.size()) { // if there is a path to all of the values
                    mothers.add(value); // then it must be a mother value
                }

            }
        }
        
        return mothers;
    }

    public static void main(String[] args) {
        Graph<String> graph = new AdjacencyGraph<>();
        for (char ch = 'A'; ch <= 'E'; ch++) {
            graph.add("" + ch);
        }
        graph.connectDirected("E", "A");
        graph.connectDirected("A", "B");
        graph.connectDirected("B", "E");
        graph.connectDirected("B", "C");
        graph.connectDirected("C", "D");
        List<String> values = Arrays.asList("A", "B", "C", "D", "E");
        System.out.println("Mother vertexes: " + findMothers(graph, values));

        Graph<String> graph2 = new AdjacencyGraph<>();
        for (char ch = 'T'; ch <= 'Z'; ch++) {
            graph2.add("" + ch);
        }
        graph2.connectDirected("Z", "U");
        graph2.connectDirected("Z", "Y");
        graph2.connectDirected("X", "U");
        graph2.connectDirected("X", "T");
        graph2.connectDirected("Y", "X");
        graph2.connectDirected("Y", "W");
        graph2.connectDirected("W", "T");
        graph2.connectDirected("T", "V");
        List<String> values2 = Arrays.asList("T", "U", "V", "W", "X", "Y", "Z");
        System.out.println("Mother vertexes: " + findMothers(graph2, values2));


    }
}
