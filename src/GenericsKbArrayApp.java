/**
 * reads in data from a file then creates Statements objects from each line
 * Has functionality to deal with user input: read in, add a term, search by term, search by term and statement, quit
 * @author Uzayr Ismail
 * @version 1.0
 * @since 26/02/2024
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class GenericsKbArrayApp {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Statements[] statementsArray = new Statements[50000];
        Scanner kb = new Scanner(System.in);
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
                    int i = 0;
                    while (myScanner.hasNextLine()) {
                        String data = myScanner.nextLine();
                        Statements statementsObject = new Statements(data);
                        statementsArray[i] = statementsObject;
                        i ++;
                    }
                    myScanner.close();
                }
                catch (FileNotFoundException e) {
                    System.out.println("File not found");
                }
                if (statementsArray != null) {System.out.println("Knowledge base loaded successfully.");}
            }
            else if (input == 2) {
                System.out.println("Enter the term: ");
                String term = kb.nextLine();
                System.out.println("Enter the statement: ");
                String statement = kb.nextLine();
                System.out.println("Enter the confidence score: ");
                String score = kb.nextLine();
                Statements newStatement = new Statements(term + "\t" + statement + "\t" + score + "\n");
                for (int i = 0; i < statementsArray.length; i++) {
                    Statements s = statementsArray[i];
                    if (s == null) {System.out.println("Encountered null statement in statementsArray at index: " + i);}
                    else if (newStatement == null) {System.out.println("newStatement is null");}
                    else if (s.compareTerm(newStatement.getTerm()) == 1) {
                        if (s.compareConfidenceRating(newStatement) == 1) {
                            s.updateStatement(newStatement);
                        }
                    }
                    else {
                        try {
                            FileWriter writer = new FileWriter("GenericsKB.txt");
                            writer.write(term + "\t" + statement + "\t" + score + "\n");
                            writer.close();
                        }
                        catch (IOException e) {
                            System.out.println("An error has occurred");
                        }
                    }
                }
                System.out.printf("Statement for term %s has been updated \n", term);
            }
            else if (input == 3) {
                System.out.println("Enter the term to search: ");
                String term = kb.nextLine();
                int foundCount = 0;
                for (int i = 0; i < statementsArray.length; i++) {
                    Statements  s = statementsArray[i];
                    if (s.compareTerm(term) == 1) {
                        System.out.printf("Statement found: %s (Confidence score: %s) \n", s.getSentence(), s.getConfidenceRating());
                        foundCount ++;
                    }
                }
                if (foundCount == 0) { System.out.println("Term not found.");}      
            }
            else if (input == 4) {
                System.out.println("Enter the term: ");
                String term = kb.nextLine();
                System.out.println("Enter the statement: ");
                String statement = kb.nextLine();
                int i = 0;
                for (Statements s : statementsArray) {
                    if (s.compareTerm(term) == 1) {
                        if (s.compareSentence(statement) == 1) {
                            System.out.printf("The statement was found and has a confidence score of %s.", s.getConfidenceRating());
                            i ++;
                        }
                    }
                }
                if (i == 0) {System.out.println("Statement was not found.");}
            }
            else if (input == 5) {break;}
        }
        kb.close();
    }    
}