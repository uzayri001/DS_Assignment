public class BinarySearchTree {
    Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }
    private Node insertHelper(Node root, Node node) {
        Statements statement = node.statement;
        if (root == null) {
            root = node;
            return root;
        }
        else if (statement.sortAlphabetical(root) == -1) {
            root.left = insertHelper(root.left, node);
        }
        else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }
    public void display() {}
    private void displayHelper(Node root) {}
    public boolean search(int data) {return false;}
    private boolean searchHelper(Node root, int data) {return false;}
    public void remove(int data) {}
    public Node removeHelper(Node root, int data) {return null;}
    private int successor(Node root) {return 0;}
    private int predecessor(Node root) {return 0;}
}
