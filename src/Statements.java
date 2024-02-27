/** 
 * Class to arrange each line of the file into a term, sentence and confidence Rating.
 * Data from file will be stored as an array of objects of this class.
 * 
 * @author Uzayr Ismail
 * @version 1.0
 * @since 27/02/2024
*/


public class Statements {
    private String term;
    private String sentence;
    private String confidenceRating;

    /**
     * Constructor method that splits each statement into 3 parts
     * @param inputStatement
     */
    public Statements (String inputStatement) {
        String[] statements = inputStatement.split("\t");
        for (String statement : statements) {
            int i = 0;
            i ++;
            if (i == 1) { term = statement; }
            else if (i == 2) { sentence = statement; }
            else {confidenceRating = statement; }
        }
    }

    /**
     * @return the term of the statement
     */
    public String getTerm() {return term;}

    /**
     * @return the sentence part of the statement
     */
    public String getSentence() {return sentence;}

    /**
     * @return the confidence rating of the statement
     */
    public String getConfidenceRating() {return confidenceRating;}
    
}
