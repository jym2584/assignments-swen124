
package graphs;


public class Graphs {
    
    
    public static Graph<String> makeGraph () {
        Graph <String> graph = new AdjacencyGraph <>();

        for (char ch = 'A'; ch < 'L'; ch++) {
            graph.add("" + ch);
        }

        graph.connectUndirected("A", "B");
        graph.connectDirected("A", "C");
        graph.connectUndirected("B", "E");
        graph.connectUndirected("C", "D");
        graph.connectUndirected("C", "E");
        graph.connectDirected("C", "H");
        graph.connectDirected("D", "B");
        graph.connectUndirected("D", "F");
        graph.connectDirected("E", "F");
        graph.connectUndirected("F", "G");
        
        graph.connectUndirected("I", "K");
        graph.connectUndirected("K", "J");
        graph.connectDirected("J", "I");
        

        return graph;
    }
}
