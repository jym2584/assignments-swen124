package bst;

/**
 * Node implementation for binary trees
 */
public class BinaryNode<T> {
    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    /**
     * Constructor
     * @param value Node value
     */
    public BinaryNode (T value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString () {
        return "BinaryNode {value: " + value + ", left: " + left +
               ", right: " + right + "}";
    }

    /**
     * Returns the node's value
     * @return value
     */
    public T getValue () {
        return value;
    }

    /**
     * Sets the node's value
     * @param value Value to be assigned to the node
     */
    public void setValue (T value) {
        this.value = value;
    }

    /**
     * Returns the node's left reference
     * @return left reference
     */
    public BinaryNode<T> getLeft () {
        return left;
    }

    /**
     * Sets the node's left reference
     * @param left
     */
    public void setLeft (BinaryNode<T> left) {
        this.left = left;
    }

    /**
     * Returns the nodes right reference
     * @return right reference
     */
    public BinaryNode<T> getRight () {
        return right;
    }

    /**
     * Sets the node's right reference
     * @param right
     */
    public void setRight (BinaryNode<T> right) {
        this.right = right;
    }

    /**
     * Performs an infix traversal of the binary tree
     * @return Stringifyed version of the Binary Tree
     */
    public String infixTraversal () {
        String tree = "";
        if (left != null) {
            tree += left.infixTraversal ();
        }

        tree += value + " ";

        if (right != null) {
            tree += right.infixTraversal ();
        }

        return tree;
    }

    /**
     * Searches the tree for a target value
     * @param target Value to search for in the tree
     * @return true if the target is found false otherwise
     */
    public boolean search (T target) {
        if (value == target) {
            return true;
        }

        if (left != null) {
            if (left.search (target) == true) {
                return true;
            }
        }

        if (right != null) {
            if (right.search (target)) {
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        BinaryNode<Integer> two = new BinaryNode<> (2);
        BinaryNode<Integer> three = new BinaryNode<> (3);
        BinaryNode<Integer> nine = new BinaryNode<> (9);
        BinaryNode<Integer> four = new BinaryNode<> (4);
        BinaryNode<Integer> seven = new BinaryNode<> (7);
        BinaryNode<Integer> one = new BinaryNode<> (1);
        BinaryNode<Integer> six = new BinaryNode<> (6);

        BinaryNode<Integer> root = new BinaryNode<> (2);
        //root.binaryInsert (3);
        //root.binaryInsert (9);
        //root.binaryInsert (4);
        //root.binaryInsert (7);
        //root.binaryInsert (1);
       // root.binaryInsert (6);

        System.out.println (root.infixTraversal ());
       // System.out.println (root.binarySearch (6));
       // System.out.println (root.binarySearch (9));
       // System.out.println (root.binarySearch (15));
    }
}