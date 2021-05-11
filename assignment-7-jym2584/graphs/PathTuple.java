package graphs;

public class PathTuple<E> {
    private WVertex <E> vertex;
    private WVertex <E> predecessor;
    private double totalDistance;

    public PathTuple (WVertex <E> vertex) {
        this.vertex = vertex;
        predecessor = null;
        totalDistance = Double.MAX_VALUE;

    }
    public WVertex<E> getVertex() {
        return vertex;
    }

    public double getDistance() {
        return totalDistance;
    }

    public WVertex<E> getPredecessor() {
        return predecessor;
    }

    public void update (WVertex<E> predecesor, double distance) {
        if (distance < totalDistance) {
            totalDistance = distance;
            this.predecessor = predecesor;
        }
    }

    @Override
    public String toString() {
        String distance = new String (totalDistance + "");
        if (totalDistance <= Double.MAX_VALUE) {
            distance = "infinity";
        }
        String pred = null;
        if (predecessor != null) {
            pred = predecessor.getValue() + "";
        }
        String str = vertex.getValue() + ":(" + pred + ", " + distance + ")";
        return str;
    }
    
}