/**
 * creates a Binary search tree from a Node
 * insert, display, search, remove functionality included
 * @author Uzayr Ismail
 * @version 1.0
 * @since 04/03/2024
 */

public class BinarySearchTree {
    Node root;

    /**
     * Insert method
     * @param node
     */
     public void insert(Node node) {
        root = insertHelper(root, node);
    }
    /**
     * Helper method for insert to help with recursion
     * @param root,node
     * @return Node
     */
    private Node insertHelper(Node root, Node node) {
        Statements statement = node.statement;
        if (root == null) {
            root = node;
            return root;
        }
        else if (statement.sortAlphabetical(root.statement) < 0) {
            root.left = insertHelper(root.left, node);
        }
        else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }
    
    /**
     * display method
     */
    public void display() {displayHelper(root);}
    /**
     * helper method to deal with recursion8
     * @param root
     */
    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.statement);
            displayHelper(root.right);
        }
    }
    
    /**
     * @param term
     * @return Node
     */
    public Node searchByTerm(String term) {
        return searchHelperByTerm(root, term);
    }
    /**
     * @param root
     * @param term
     * @return Node
     */
    private Node searchHelperByTerm(Node root, String term) {
        if (root == null) {return null;}
        else if (root.statement.compareTerm(term) == 0) {return root;}
        else if (root.statement.compareTerm(term) == 1) {return searchHelperByTerm(root.left, term);}
        else {return searchHelperByTerm(root.right, term);}
    }

    /**
     * @param sentence
     * @return boolean
     */
    public boolean searchByStatement(String sentence) {
        return searchHelperByStatement(root, sentence);
    }
    /**
     * @param root
     * @param sentence
     * @return boolean
     */
    private boolean searchHelperByStatement(Node root, String sentence) {
        if (root == null) {return false;}
        else if (root.statement.compareSentence(sentence) == 1) {return true;}
        else if (root.statement.compareSentence(sentence) == -1) {return searchHelperByStatement(root.left, sentence);}
        else {return searchHelperByStatement(root.right, sentence);}
    }
}
