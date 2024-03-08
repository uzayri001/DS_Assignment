import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class GenericsKbBSTApp {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        while (true) {
            System.out.println("Choose an action from the menu:\n 1. Load a knowledge base from a file \n 2. Add a new statement to the knowledge base \n 3. Search for an item in the knowledge base by term \n 4. Search for a item in the knowledge base by term and sentence \n 5. Quit");
            System.out.print("Enter your choice: ");
            int input = kb.nextInt();
            kb.nextLine();
            if (input == 1) {
                System.out.println("Enter the file name: ");
                String fileName = kb.nextLine();
                try {
                    File myFile = new File(fileName);
                    Scanner myScanner = new Scanner(myFile);
                    while (myScanner.hasNextLine()) {
                        String data = myScanner.nextLine();
                        Statements statementsObject = new Statements(data);
                        Node newNode = new Node(statementsObject);
                        binarySearchTree.insert(newNode);

                    }
                    myScanner.close();
                }
                catch (FileNotFoundException e){
                    System.out.println("File not found.");
                }
            
            }
            if (input == 3) {
                System.out.println("Enter the term to search: ");
                String term = kb.nextLine();
                if (binarySearchTree.searchByTerm(term) == true) {
                    System.out.println(binarySearchTree.root.statement.toString());
                }
            }
            if (input == 4) {
                System.out.println("Enter the term: ");
                String term = kb.nextLine();
                System.out.println("Enter the statement to search for: ");
                String statement = kb.nextLine();
                if (binarySearchTree.searchByTerm(term) == true) {
                    if (binarySearchTree.searchByStatement(statement) == true) {
                        System.out.printf("The statement was found and has a confidence score of %s", binarySearchTree.root.statement.getConfidenceRating());
                    }
                }
            }
            if (input == 5) {
                break;
            }
        }
        kb.close();
    }
}
