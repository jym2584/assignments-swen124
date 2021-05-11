package bst;

import java.util.*;

import graphs.*;

public class BstAsGraph {
    public static BinaryNode makeBST(int[] array) {
        BinaryNode node = new BinaryNode(array[0]);
        
        for(int i = 1; i < array.length; i++) {
            node.binaryInsert(array[i]);
        }

        return node;
    }

    public static Graph<Integer> convertToGraph(BinaryNode bst) {
        Graph<Integer> graph = new AdjacencyGraph<>();

        ArrayDeque<BinaryNode> unchecked = new ArrayDeque<>();
        unchecked.add(bst); // add root value to the list of unchecked

        while(!unchecked.isEmpty()) { // while we haven't checked everything on the BinaryNode
            BinaryNode toCheck = unchecked.peekFirst();
            graph.add(toCheck.getValue()); // add value to the graph
            //System.out.println("NOW HEAD: " + toCheck.getValue());

            List<BinaryNode> getLeftAndRight = getNodesFromHead(toCheck); // get left and right nodes
            //System.out.println(String.format("   LEFT: %s \n   RIGHT: %s", getLeftAndRight.get(0), getLeftAndRight.get(1)));

            for(int i = 0; i < getLeftAndRight.size(); i++) {
                BinaryNode currentNode = getLeftAndRight.get(i); // gets a current node

                if(currentNode != null) { // if left or right node exists from the toCheck node
                    //System.out.println("- CHECKING HEAD: " + toCheck.getValue());
                    //System.out.println("- CHECKING CURRENT (left or right) VALUE: " + currentNode.getValue());
                    
                    graph.add(currentNode.getValue());
                    graph.connectUndirected(toCheck.getValue(), currentNode.getValue()); // connect left and right values to the graph
                    
                    //System.out.println("   CONNECTED " + toCheck.getValue() + " WITH " + currentNode.getValue());
                    unchecked.add(currentNode); // add them to check
                }
            }

            unchecked.removeFirst(); // remove the node from the to check list

        }
        return graph;
    }


    /**
     * Gets the left and right nodes from the one that we want to search for
     * @param node head of the node
     * @return left and right values from node
     */
    public static List<BinaryNode> getNodesFromHead(BinaryNode node) {
        List<BinaryNode> list = new ArrayList<>();

        if(node.getLeft() == null) {
            list.add(null);
        } else {
            list.add(node.getLeft());
        }

        if (node.getRight() == null) {
            list.add(null);
        } else {
            list.add(node.getRight());
        }

        return list;
    }



    public static void main(String[] args) {
        int[] array = {4,7,2,5,1,8,3};

        BinaryNode node = makeBST(array);
        System.out.println(node.infixTraversal());


        Graph<Integer> graph = convertToGraph(node);
        System.out.println(graph);
    }

}
