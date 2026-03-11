public class Levenshtein implements SequenceScoringAlgorithm {
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

    @Override
    public String getName(){
        return "Levenshtein match";
    }

    @Override
    public boolean higherScoreIsBetter() {
        return false;
    }



}