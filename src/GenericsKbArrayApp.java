import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenericsKbArrayApp {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an action from the menu:/n 1. Load a knowledge base from a file /n 2. Add a new statement to the knowledge base /n 3. Search for an item in the knowledge base by term /n 4. Search for a item in the knowledge base by term and sentence /n 5. Quit");
            System.out.print("Enter your choice: ");
            int input = kb.nextInt();
            if (input == 1) {
                System.out.println("Enter the file name: ");
                String fileName = kb.nextLine();
                try {
                    File myFile = new File(fileName);
                    Scanner myScanner = new Scanner(myFile);  
                    myScanner.close();
                }
                catch (FileNotFoundException e) {
                    System.out.println("File not found");
                }
            }
            else if (input == 2) {
                System.out.println("Enter the term: ");
                String term = kb.nextLine();
                System.out.println("Enter the statement: ");
                String statement = kb.nextLine();
                System.out.println("Enter the confidence score: ");
                Double score = kb.nextDouble();
                System.out.println("Statement for term %s has been updated.");
            }
            else if (input == 3) {
                System.out.println("Enter the term to search: ");
                String term = kb.nextLine();
                System.out.println("Statement found");          
            }
            else if (input == 4) {
                System.out.println("Enter the term: ");
                String term = kb.nextLine();
                System.out.println("Enter the statement: ");
                String statement = kb.nextLine();
                System.out.println("Statement found");
            }
            else if (input == 5) {break;}
        }
    }    
}