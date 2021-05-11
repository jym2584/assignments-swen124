package pokedex;
import trees.BinaryNode;

public class Pokedex {

    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(26);  
        root.binaryInsert(4);  
        root.binaryInsert(130); 
        root.binaryInsert(7); 
        root.binaryInsert(129); 
        
        System.out.println(root.infixTraveral());
        System.out.println(root.binarySearch(7));
    }
}
