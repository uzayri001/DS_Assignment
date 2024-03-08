import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * creates a BinarySearchTree Object using data from the KB text file
 * able to search for and add terms
 * @author Uzayr Ismail
 * @version 1.0
 * @since 05/03/2024
 */

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
                if (binarySearchTree.root != null) {System.out.println("Knowledge base loaded successfully.");}
            }
            else if (input == 2) {
                System.out.println("Enter the term: ");
                String term = kb.nextLine();
                System.out.println("Enter the statement: ");
                String sentence = kb.nextLine();
                System.out.println("Enter the confidence score: ");
                String rating = kb.nextLine();
                if (binarySearchTree.searchByTerm(term) != null) {
                    Double termRating = Double.parseDouble(binarySearchTree.searchByTerm(term).statement.getConfidenceRating());
                    if (Double.parseDouble(rating) <= termRating) {
                        binarySearchTree.searchByTerm(term).statement.setConfidenceRating(rating);
                        binarySearchTree.searchByTerm(term).statement.setSentence(sentence);
                    }
                }
                else {
                    Statements newStatement = new Statements(term + "\t" + sentence + "\t" + rating);
                    Node newNode = new Node(newStatement);
                    binarySearchTree.insert(newNode);
                }
                System.out.printf("Statement for term %s has been updated.", term);
            }
            else if (input == 3) {
                System.out.println("Enter the term to search: ");
                String term = kb.nextLine();
                if (binarySearchTree.searchByTerm(term) != null) {
                    Statements searchedStetement = new Statements(binarySearchTree.searchByTerm(term).statement.toString());
                    System.out.printf("Statement found: %s. (Confidence score: %s)", searchedStetement.getSentence(), searchedStetement.getConfidenceRating());
                }
            }
            else if (input == 4) {
                System.out.println("Enter the term: ");
                String term = kb.nextLine();
                System.out.println("Enter the statement to search for: ");
                String statement = kb.nextLine();
                if (binarySearchTree.searchByTerm(term) != null) {
                    while (binarySearchTree.searchByStatement(statement) == false) {
                        System.out.printf("The statement was found and has a confidence score of %s. \n", binarySearchTree.searchByTerm(term).statement.getConfidenceRating());
                        break;
                    }
                }
            }
            else if (input == 5) {break;}
            else {System.out.println("Invalid input, enter an integer 1-5");}
        }
        kb.close();
    }
}