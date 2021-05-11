package bst;

public class BinarySearchTree<E extends Comparable <E>> {
    private BinaryNode<E> root;
    private int size;

    public BinarySearchTree (E initialValue) {
        root = new BinaryNode<>(initialValue);
        size = 1;
    }

    /**
     * Searchs the tree as a Binary Search Tree
     * @param target Value to search for in the tree
     * @return true if the target is found false otherwise
     */
    private boolean binarySearch (BinaryNode<E> root, E target) {
        if (root.getValue() == target) {
            return true;
        }

        if (root.getLeft() != null && target.compareTo(root.getValue()) < 0) {
            if (root.getLeft().search (target) == true) {
                return true;
            }
        }
        else if (root.getRight() != null) {
            if (root.getRight().search (target)) {
                return true;
            }
        }

        return false;
    }

    public boolean search(E target) {
        return binarySearch(root, target);
    }

    /**
     * Insert a value into the tree as a BST node
     * @param value value to insert
     */
    private void binaryInsert (BinaryNode<E> node, E value) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryNode<> (value));
            }
            else {
                binaryInsert (node.getLeft(), value);
            }
        }
        else {
            if (node.getRight() == null) {
                node.setRight(new BinaryNode<> (value));
            }
            else {
                binaryInsert (node.getRight(), value);
            }            
        }
    }
    
    public void insert(E value) {
        binaryInsert(root, value);
        size++;
    }

    /**
     * Performs an infix traversal of the binary tree
     * @return Stringifyed version of the Binary Tree
     */
    @Override
    public String toString () {
        String tree = "";
        if (root.getLeft() != null) {
            tree += root.getLeft().infixTraversal ();
        }

        tree += root.getValue() + " ";

        if (root.getRight() != null) {
            tree += root.getRight().infixTraversal ();
        }

        return tree;
    }


    public static void main(String[] args) {
        Pokemon pokemon1 = new Pokemon (130,"gyrados");
        Pokemon pokemon2 = new Pokemon (4,"charmander");
        Pokemon pokemon3 = new Pokemon (7,"squirtle");
        Pokemon pokemon4 = new Pokemon (129,"magicarp");
        Pokemon pokemon5 = new Pokemon (26,"raichu");

        BinarySearchTree<Pokemon> pokedex = new BinarySearchTree<>(pokemon1);
        pokedex.insert (pokemon2);
        pokedex.insert (pokemon3);
        pokedex.insert (pokemon4);
        pokedex.insert (pokemon5);

        System.out.println(pokedex.search(pokemon1));
        System.out.println(pokedex.search(pokemon2));
        System.out.println(pokedex.search(pokemon3));
        System.out.println(pokedex.search(pokemon4));
        System.out.println(pokedex.search(pokemon5));
        System.out.println(pokedex);

    }

}
