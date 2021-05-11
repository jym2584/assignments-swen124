package graphs;
import java.util.*;

public class WVertex<E> {
    private E value;
    private Map<WVertex<E>, Edge<E>> neighbors;
    
    public WVertex (E value) {
        this.value = value;
        neighbors = new HashMap<>();
    }

    public E getValue(){ return value; }

    public void connect(WVertex<E> neighbor, double weight) {
        Edge<E> edge = new Edge<>(this, neighbor, weight);
        neighbors.put(neighbor, edge);
    }

    public Edge edge(WVertex<E> neighbor) { return neighbors.get(neighbor); }

    public Set<Edge<E>> edges() {
        Set<Edge<E>> edges = new TreeSet<>();
        for (Edge<E> edge: neighbors.values()) {
            edges.add(edge);
        }
        return edges;
    }

    @Override
    public String toString() {
        return value.toString();
    }


}
