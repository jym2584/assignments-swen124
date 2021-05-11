package graphs;
import java.util.*;
import java.lang.Math;


public class WAdjacencyGraph<E> implements WGraph<E> {
    private Map<E, WVertex<E>> verticies;

    public WAdjacencyGraph() {
        verticies = new HashMap<>();
    }

    @Override
    public void add(E value) {
        WVertex<E> vertex = new WVertex<E>(value);
        verticies.put(value, vertex);
    }

    @Override
    public boolean contains(E value) {
        return verticies.containsKey(value);
    }

    @Override
    public int size() {
        return verticies.size();
    }

    @Override
    public void connect(E a, E b, double weight) {
        WVertex<E> av = verticies.get(a);
        WVertex<E> bv = verticies.get(b);
        av.connect(bv, weight);
        bv.connect(av, weight);

        
    }

    @Override
    public boolean connected(E a, E b) {
        WVertex<E> av = verticies.get(a);
        WVertex<E> bv = verticies.get(b);
        return av.edge(bv) != null;
    }

    @Override
    public double weight(E a, E b) {
        WVertex <E> av = verticies.get (a); 
        WVertex <E> bv = verticies.get (b);
        return av.edge (bv).getWeight();       
    }


    @Override
    public WPath<E> nearestNeighbors(E start, E end) {
        WVertex<E> s = verticies.get(start);
        WVertex<E> e = verticies.get(end);

        Set<WVertex<E>> visited = new HashSet<>();
        visited.add(s);

        return visitNearestNeighbor(s, e, visited);
    }

    private WPath<E> visitNearestNeighbor(WVertex<E> v, WVertex<E> e, 
        Set<WVertex<E>> visited) {
        if(v == e) {
            WPath<E> path = new WPath<>(e.getValue());
            return path;
        } else {
            for(Edge<E> edge : v.edges()) {
                WVertex<E> neighbor = edge.getTo();
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    WPath<E> path = visitNearestNeighbor(neighbor, e, visited);
                    if(path != null) {
                        path.prepend(v.getValue(), edge.getWeight());
                        return path;
                    }
                }
            }
            return null;
        }
    }
    
}
