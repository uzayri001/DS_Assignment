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
        else if (statement.sortAlphabetical(root.statement) == -1) {
            root.left = insertHelper(root.left, node);
        }
        else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }
    public void display() {displayHelper(root);}
    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.statement);
            displayHelper(root.right);
        }
    }
    public boolean searchByTerm(String term) {
        return searchHelperByTerm(root, term);
    }
    private boolean searchHelperByTerm(Node root, String term) {
        if (root == null) {return false;}
        else if (root.statement.compareTerm(term) == 0) {return true;}
        else if (root.statement.compareTerm(term) == 1) {return searchHelperByTerm(root.left, term);}
        else {return searchHelperByTerm(root.right, term);}
    }

    public boolean searchByStatement(String sentence) {
        return searchHelperByStatement(root, sentence);
    }
    private boolean searchHelperByStatement(Node root, String sentence) {
        if (root == null) {return false;}
        else if (root.statement.compareSentence(sentence) == 0) {return true;}
        else if (root.statement.compareSentence(sentence) == 1) {return searchHelperByStatement(root.left, sentence);}
        else {return searchHelperByStatement(root.right, sentence);}
    }

    public void remove(Statements statement) {
        if (searchByTerm(statement.getTerm())) {removeHelper(root, statement);}
        else {System.out.println(statement.toString() + " could not be found.");}
    }
    public Node removeHelper(Node root, Statements statement) {
        if (root == null) {return root;}
        else if (root.statement.sortAlphabetical(statement) == -1) {
            root.left = removeHelper(root.left, statement);
        }
        else if (root.statement.sortAlphabetical(statement) == 1) {
            root.right = removeHelper(root.right, statement);
        }
        else {
            if (root.left == null && root.right == null) { root = null;}
            else if (root.right != null) {
                root.statement = successor(root);
                root.right = removeHelper(root.right, root.statement);
            }
            else {
                root.statement = predecessor(root);
                root.left = removeHelper(root.left, statement);
            }
        }
        return root;
    }
    private Statements successor(Node root) {
        root = root.right;
        while (root.left != null) {root = root.left;}
        return root.statement;
    }
    private Statements predecessor(Node root) {
        root = root.left;
        while (root.right != null) {root = root.right;}
        return root.statement;
    }
}
