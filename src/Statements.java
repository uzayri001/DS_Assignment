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
        int i = 0;
        for (String statement : statements) {
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

    /**
     * function that compares the confidence rating of two Statements objects
     * returns -1 if rating of this is bigger than other
     * returns 1 if rating of this is smaller than or equal to other 
     * @param other
     * @return int
     */
    public int compareConfidenceRating(Statements other) {
        double otherRating = Double.parseDouble(other.getConfidenceRating());
        double thisRating = Double.parseDouble(this.getConfidenceRating());
        if (otherRating < thisRating) {return -1;}
        else {return 1;}
    }

    /**
     * compares the term for two Statement objects
     * return 1 if if it's the same, -1 if its not
     * @param other
     * @return int
     */
    public int compareTerm(String other) {
        String thisTerm = this.getTerm();
        if (other.equalsIgnoreCase(thisTerm)) {
            return 0;
        }
        else if (thisTerm.charAt(0) - other.charAt(0) < 0) {return -1;}
        else {
            return 1;
        }
    }

   /**
     * @param other
     * @return int
     */
     public int compareSentence(String other) {
        String thisSentence = this.getSentence();
        if (other.equalsIgnoreCase(thisSentence)) {
            return 1;
        }
        else {return -1;}
    }

    /**
     * updates the current Statements object by changing its term,sentence and rating to that of other
     * @param other
     */
    public void updateStatement(Statements other) {
        this.term = other.term;
        this.confidenceRating = other.confidenceRating;
        this.sentence = other.confidenceRating;
    }

    public int sortAlphabetical(Statements other) {
        String thisTerm = this.getTerm();
        String otherTerm = other.getTerm();
        int result = thisTerm.compareToIgnoreCase(otherTerm);
        return result;
    }
     
    @Override
    public String toString() {
        return this.getTerm() + "\t" + this.getSentence() + "\t" + this.getConfidenceRating() + "\n";
    }
}