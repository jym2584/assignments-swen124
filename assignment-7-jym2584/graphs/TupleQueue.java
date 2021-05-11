package graphs;
import ds.*;
import ds.Queue;

import java.util.*;


public class TupleQueue<E> implements Queue<PathTuple<E>> {
    private List <PathTuple <E>> queue; 
    public TupleQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void enqueue( PathTuple <E> element) {
        queue.add(element);
    }

    @Override
    public PathTuple<E> dequeue() {
        PathTuple <E> found = null;
        double distance = Double.MAX_VALUE;
        for (PathTuple <E> tuple : queue) {
            if (tuple.getDistance() <= distance) {
                found = tuple;
                distance = tuple.getDistance();
                
            }
        }
        if (found != null) {
            queue.remove (found);
        }
        return found;
    }

    @Override
    public int size() {
        return queue.size();
    }
    
}
