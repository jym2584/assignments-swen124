package imdb;
import graphs.*;

public class SixDegrees {
    public static void main(String[] args) {
        Graph<String> graph = new AdjacencyGraph<>();


        String movie1 = "Forrest Gump";
        graph.add(movie1);
            graph.add("Tom Hanks");
            graph.add("Rebecca Williams");
            graph.add("Sally Field");

            graph.connectUndirected(movie1, "Tom Hanks");
            graph.connectUndirected(movie1, "Rebecca Williams");
            graph.connectUndirected(movie1, "Sally Field");

        String movie2 = "Saving Private Ryan";
        graph.add(movie2);
            graph.add("Tom Sizemore");
            graph.add("Edward Burns");

            graph.connectUndirected(movie2, "Tom Hanks"); // Also in movie1
            graph.connectUndirected(movie2, "Tom Sizemore");
            graph.connectUndirected(movie2, "Edward Burns");


        String movie3 = "The Relic";
        graph.add(movie3);
            graph.add("Penelope Ann Miller");
            graph.add("Linda Hunt"); //

            graph.connectUndirected(movie3, "Tom Sizemore"); // Also in movie2
            graph.connectUndirected(movie3, "Penelope Ann Miller");
            graph.connectUndirected(movie3, "Linda Hunt");

        String movie4 = "Kindergarten Cop";
        graph.add(movie4);
            graph.add("Arnold Schwarzenegger");
            graph.add("Pamela Reed");

            graph.connectUndirected(movie4, "Linda Hunt"); // Also in movie3
            graph.connectUndirected(movie4, "Arnold Schwarzenegger");
            graph.connectUndirected(movie4, "Pamela Reed");


        // BFS Paths
        System.out.println(graph.bfPath("Tom Hanks", "Pamela Reed"));
        System.out.println(graph.bfPath("Rebecca Williams", "Arnold Schwarzenegger"));
        System.out.println(graph.bfPath("Tom Sizemore", "Linda Hunt"));
        System.out.println(graph.bfPath("Linda Hunt", "Penelope Ann Miller"));


    }
}
