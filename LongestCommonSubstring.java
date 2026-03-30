/**
 * A simple example similarity algorithm.
 *
 * This algorithm counts the number of matching subsequences
 * in corresponding positions up to the length of the shorter sequence.
 *
 * @author Landry Vewenda
 * @version 2026-03-27
 */
 
public class LongestCommonSubstring implements SequenceScoringAlgorithm {
    /**
     * Counts matching positions between two DNA sequences up to the
     * length of the shorter sequence.
     *
     * @param databaseSequence a DNA sequence from the database
     * @param querySequence the query DNA sequence
     * @return the number of matching subsequences
     */
    @Override
    public double score(String databaseSequence, String querySequence){
        int m = databaseSequence.length();
        int n = querySequence.length();

        int [][] dp = new int[m + 1][n + 1];

        int matches = 0;

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){

                if (databaseSequence.charAt(i - 1) == querySequence.charAt(j -1)){
                    dp[i][j] = dp[i - 1][j -1] + 1;

                    matches = Math.max(matches, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }

            }
        }
        return matches;


    }

     /**
     * Returns the display name of this algorithm.
     * @return the algorithm name
     */
    @Override
    public String getName(){
        return "Longest Common Substring";
    }

    /**
     * Indicate that larger scores are better matches.
     * @return false because less matching positions means a better match
     */
    @Override
    public boolean higherScoreIsBetter() {
        return true;
    }



    
}
