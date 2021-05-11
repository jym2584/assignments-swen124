package graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

/**
 * ConnectedComponents Test
 */
@Testable

public class countConnectedComponentsTest {
    /**
     * Copying directly from the files
     * Apparently they count 1 up from their intended which is reflected on the main.java
     * This test is from bipartite.txt which correctly prints 3 on main.java
     */
    @Test
    public void testCountConnectedComponent_4() {
        Graph<String> graph = new AdjacencyGraph<>();

        for (char ch = 'A'; ch <= 'I'; ch++) {
            graph.add("" + ch);
        }
        
        graph.connectDirected("A", "E");
        graph.connectDirected("A", "F");
        graph.connectDirected("A", "I");
        graph.connectDirected("B", "G");
        graph.connectDirected("C", "H");
        graph.connectDirected("D", "H");

        assertEquals(3, graph.countConnectedComponents()-1);
    }

    /**
     * Copying directly from the files
     * Apparently they count 1 up from their intended which is reflected on the main.java
     * This test is from k2_2.txt which correctly prints 1 on main.java
     */
    @Test
    public void testCountConnectedComponent_1() {
        Graph<String> graph = new AdjacencyGraph<>();

        for (char ch = 'A'; ch <= 'D'; ch++) {
            graph.add("" + ch);
        }
        
        graph.connectDirected("A", "C");
        graph.connectDirected("A", "D");
        graph.connectDirected("B", "C");
        graph.connectDirected("B", "D");

        assertEquals(1, graph.countConnectedComponents()-1);
    }
    /**
     * Correctly prints 4 now?
     */
    @Test
    public void testCountConnectedComponent_edgeCase() {
        Graph<String> graph = new AdjacencyGraph<>();

        for (char ch = 'A'; ch <= 'D'; ch++) {
            graph.add("" + ch);
        }
        

        assertEquals(4, graph.countConnectedComponents());
    }
    /**
     * Prints 0 correctly
     */
    @Test
    public void testCountConnectedComponent_edgeCase_0() {
        Graph<String> graph = new AdjacencyGraph<>();
        
        assertEquals(0, graph.countConnectedComponents());
    }
}
