package bst;
import bst.BstAsGraph;
import graphs.Graph;
import graphs.Vertex;

import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class BstAsGraphTest {
    @Test
    public void TestMakeBST() {
        int[] array = {4,7,2,5,1,8,3};

        BinaryNode node = BstAsGraph.makeBST(array);

        assertEquals("1 2 3 4 5 7 8 ", node.infixTraversal());
    }

    @Test
    public void TestConvertToGraph() {
        int[] array = {4,7,2,5,1,8,3};
        BinaryNode node = BstAsGraph.makeBST(array);

        Graph<Integer> graph = BstAsGraph.convertToGraph(node);

        List<BinaryNode> unchecked = new ArrayList<>();
        unchecked.add(node);

        while(!unchecked.isEmpty()) { // while we haven't checked everything on the BinaryNode
            BinaryNode toCheck = unchecked.get(0);
            graph.add(toCheck.getValue()); // add value to the graph

            List<BinaryNode> getLeftAndRight = BstAsGraph.getNodesFromHead(toCheck); // get left and right nodes

            for(int i = 0; i < getLeftAndRight.size(); i++) {
                BinaryNode currentNode = getLeftAndRight.get(i);

                if(currentNode != null) { // if nodes exist on the left and right from the root

                    graph.add(currentNode.getValue());
                    graph.connectUndirected(toCheck.getValue(), currentNode.getValue()); // connect left and right values to the graph
                    
                    // verify to check if its actually connected now
                    assertTrue(graph.connected(toCheck.getValue(), currentNode.getValue()));
                    System.out.println(
                        String.format("%s connected with HEAD %s: %s", 
                            currentNode.getValue(), 
                            toCheck.getValue(), 
                            graph.connected(toCheck.getValue(), currentNode.getValue())
                        )
                    );

                    unchecked.add(currentNode); // add them to check
                }
            }

            unchecked.remove(toCheck); // remove the node from the to check list

        }

        
    }
}
