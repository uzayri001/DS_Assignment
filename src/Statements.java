public class Statements {
    private String term;
    private String sentence;
    private String confidenceRating;

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

    public String getTerm() {return term;}

    public String getSentence() {return sentence;}

    public String getConfidenceRating() {return confidenceRating;}
    
}
