package graphs;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AdjacencyGraph <E> implements Graph <E> {

    private Map <E, Vertex <E>> verticies;

    public List<E> makePath(Map<Vertex<E>, Vertex<E>> predecessors, Vertex<E> target) {
        if(!predecessors.containsKey(target)) {
            return null;
        }
        List<E> path = new LinkedList<>();
        while (target != null) {
            path.add(0, target.getValue());
            target = predecessors.get(target);

        }
        return path;
    }

    public AdjacencyGraph () {
        verticies = new HashMap<> ();
    }


    @Override
    public void add(E value) {
        Vertex <E> vertex = new Vertex<> (value);
        verticies.put(value, vertex);
    }

    @Override
    public boolean contains (E value) {
        return verticies.containsKey(value);
    }

    @Override
    public int size() {
        return verticies.size();
    }

    @Override
    public void connectDirected(E a, E b) {
        Vertex <E> ver_a = verticies.get(a);
        Vertex <E> ver_b = verticies.get(b);
        ver_a.connect(ver_b);
    }

    @Override
    public void connectUndirected(E a, E b) {
        Vertex <E> ver_a = verticies.get(a);
        Vertex <E> ver_b = verticies.get(b);
        ver_a.connect(ver_b);
        ver_b.connect(ver_a);
    }

    @Override
    public boolean connected(E a, E b) {
        Vertex <E> ver_a = verticies.get(a);
        Vertex <E> ver_b = verticies.get(b);
        return ver_a.connected(ver_b);
    }

    @Override
    public boolean bfSearch(E start, E end) {
        Vertex<E> begin = verticies.get(start);
        Vertex<E> stop = verticies.get(end);
        java.util.Queue<Vertex <E>> queue = new LinkedList<>();
        Set<Vertex<E>> visited = new HashSet<>();
        queue.offer(begin);
        visited.add(begin);
        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            if(current == stop) {
                return true;
            } else {
                for (Vertex<E> neighbor: current.getNeighbors()) {
                    if (!visited.contains(neighbor)) { // if there is no neighbor on the set
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }

        return false;
    }

    @Override
    public List<E> bfPath(E start, E end) {
        Vertex<E> begin = verticies.get(start);
        Vertex<E> stop = verticies.get(end);
        java.util.Queue<Vertex <E>> queue = new LinkedList<>();
        Map<Vertex<E>, Vertex<E>> predecessors = new HashMap<>();

        queue.offer(begin);
        predecessors.put(begin, null);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll(); // get current item
            if(current == stop) {
                break;
            } else {
                for (Vertex<E> neighbor: current.getNeighbors()) {
                    if (!predecessors.containsKey(neighbor)) { // if there is no neighbor on the set
                        queue.offer(neighbor);
                        predecessors.put(neighbor, current);
                    }
                }
            }
        }
        return makePath(predecessors, stop);
    }

    @Override
    /** 
     * Counts connected components
     * @return returns counted components
    */
    public int countConnectedComponents() {
        Set<Vertex<E>> visited = new HashSet<>();
        int count = 0;

        for(Vertex<E> vertex: verticies.values()) {
            if(!visited.contains(vertex)) { // If the vertex is already on the set
                count++;

                Queue<Vertex<E>> queue = new LinkedList<>();
                queue.add(vertex);
                while(!queue.isEmpty()) { 
                    Vertex<E> next = queue.poll(); // Add the next vertex to the queue
                    for(Vertex<E> neighbor: next.getNeighbors()) { // And get the connected components
                        if(!visited.contains(neighbor)) {
                            visited.add(neighbor); // Add the vertexes to the set
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
        return count;
    }

    private void visitDFS(Vertex<E> vertex, Set<Vertex<E>> visited) {
        for(Vertex<E> neighbor: vertex.getNeighbors()) {
            if(!visited.contains(neighbor)) {
                visited.add(neighbor);
                visitDFS(neighbor, visited);
            }
        }
    }

    @Override
    public boolean dfSearch(E start, E end) {
        Vertex<E> begin = verticies.get(start);
        Vertex<E> stop = verticies.get(end);
        Set<Vertex<E>> visited = new HashSet();

        visited.add(begin);
        visitDFS(begin, visited);
        return visited.contains(stop);
    }

    public List<E> visitDfPath(Vertex<E> vertex, Vertex<E> target, Set<Vertex<E>> visited) {
        List<E> path;
        if(vertex == target) {
            path = new LinkedList<>();
            path.add(vertex.getValue());
            return path;
        }

        for(Vertex<E> neighbor: vertex.getNeighbors()) {
            if(!visited.contains(neighbor)) {
                visited.add(neighbor);
                path = visitDfPath(neighbor, target, visited);
                if(path != null) {
                    path.add(0, vertex.getValue());
                    return path;
                }
            }
        }
        
        return null;

    }

    @Override
    public List<E> dfPath(E start, E end) {
        Vertex<E> begin = verticies.get(start);
        Vertex<E> stop = verticies.get(end);
        Set<Vertex<E>> visited = new HashSet<>();

        visited.add(begin);
        return visitDfPath(begin, stop, visited);
    }


}
