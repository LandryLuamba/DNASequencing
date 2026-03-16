/**
 * A simple example similarity algorithm.
 *
 * This algorithm counts the number of matching characters
 * in corresponding positions up to the length of the shorter sequence.
 *
 * @author Landry Vewenda
 * @version 2026-03-11
*/
public class Levenshtein implements SequenceScoringAlgorithm {
    /**
     * Counts matching positions between two DNA sequences up to the
     * length of the shorter sequence.
     *
     * @param databaseSequence a DNA sequence from the database
     * @param querySequence the query DNA sequence
     * @return the number of matching positions
     */
    @Override
    public double score(String databaseSequence, String querySequence) {
        int m = databaseSequence.length();
        int n = querySequence.length();
        if (m == 0) return n;
        if (n == 0) return m;
        if (databaseSequence.substring(m - 1).equals(querySequence.substring(n - 1))) {
            return score(databaseSequence.substring(0, m - 1), querySequence.substring(0, n - 1));
        }
        return 1 + Math.min(score(databaseSequence.substring(0, m - 1), querySequence.substring(0, n - 1)),
            Math.min(score(databaseSequence, querySequence.substring(0, n - 1)),
            score(databaseSequence.substring(0, m - 1), querySequence)));
    }
    
    /**
     * Returns the display name of this algorithm.
     * @return the algorithm name
     */
    @Override
    public String getName(){
        return "Levenshtein match";
    }

    /**
     * Indicate that larger scores are better matches.
     * @return false because less matching positions means a better match
     */
    @Override
    public boolean higherScoreIsBetter() {
        return false;
    }

}