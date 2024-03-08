/**
 * Node Class to be used for nodes in a BST
 * contains a Statements object as data and a left, right child
 * @author Uzayr Ismail
 * @version 1.0
 * @since 04/03/2024
 */

public class Node {
    Statements statement;
    Node left;
    Node right;

    public Node(Statements statement) {
        this.statement = statement;
    }
}
