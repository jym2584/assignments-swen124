package trees;


public class BinaryNode {
    private int value;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int value) {
        this.value = value;
        left= null;
        right = null;
    }

    @Override
    public String toString() {
        return "BinaryNode {value: " + value+ ", left: " + left + ", right: "+ right + "}";
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public String infixTraveral() {
        String tree = "";
        if (left != null) {
            tree += left.infixTraveral();
        }

        tree += value + " ";
        if (right != null) {
            tree += right.infixTraveral();
        }

        return tree;
    }

    public boolean search(int target) {
        if (value == target) {
            return true;
        }

        if (left != null) {
            if (left.search(target) == true) {
                return true;
            }
        }

        if (right != null) {
            if (right.search(target) == true) {
                return true;
            }
        }

        return false;
    }

    public boolean binarySearch(int target) {
        if (value == target) {
            return true;
        }

        if (left != null && target < value) {
            if (left.search(target) == true) {
                return true;
            }
        }
        else if (right != null) {
            if (right.search(target) == true) {
                return true;
            }
        }

        return false;
    }

    public void binaryInsert(int value) {
        if ( value < this.value) {
            if (left == null) {
                left = new BinaryNode(value);
            }
            else {
                left.binaryInsert(value);
            }
        }
        else {
            if (right == null) {
                right = new BinaryNode(value);
            }
            else {
                right.binaryInsert(value);
            }
        }
    }

    public static void main(String[] args) {
        BinaryNode two = new BinaryNode(2);
        BinaryNode three = new BinaryNode(3);
        BinaryNode nine = new BinaryNode(9);
        BinaryNode four = new BinaryNode(4);
        BinaryNode seven = new BinaryNode(7);
        BinaryNode one = new BinaryNode(1);
        BinaryNode six = new BinaryNode(6);

        BinaryNode root = new BinaryNode(2);
        root.binaryInsert(3);
        root.binaryInsert(9);
        root.binaryInsert(4);
        root.binaryInsert(7);
        root.binaryInsert(1);
        root.binaryInsert(6);

        System.out.println(root.infixTraveral());
        System.out.println(root.search(6));
        System.out.println(root.search(9));
        System.out.println(root.search(15));
    }
}
