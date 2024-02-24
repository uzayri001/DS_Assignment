import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenericsKbArrayApp {
    public static void main(String[] args) {
        try {
            File myFile = new File("GenericsKB.txt");
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                String statement = myScanner.nextLine();
                System.out.println(statement);
            }
            myScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}