package dynamic_programming;

import java.util.Arrays;

public class Question33 {
    public int minDistance(String word1, String word2) {
        return spaceOptimized(word1, word2);
    }

    public static int spaceOptimized(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int j = 0; j <= n; j++)
            prev[j] = j;

        for (int i = 1; i <= m; i++) {
            curr[0] = i;

            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(prev[j - 1],
                            Math.min(prev[j], curr[j - 1]));
                }
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    public static int tabulation(String word1, String word2) {
        final int m = word1.length();// first word length
        final int n = word2.length();/// second word length

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i)
            dp[i][0] = i;

        for (int j = 1; j <= n; ++j)
            dp[0][j] = j;

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        return dp[m][n];
    }

    public static int memorization(String word1, String word2) {
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int[] d : result) {
            Arrays.fill(d, -1);
        }

        return memorization(word1, word2, 0, 0, result);
    }

    private static int memorization(String word1, String word2, int i, int j, int[][] result) {

        // If word1 finished → insert remaining word2 chars
        if (i == word1.length()) {
            return word2.length() - j;
        }

        // If word2 finished → delete remaining word1 chars
        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (result[i][j] != -1) {
            return result[i][j];
        }

        // If characters match → move both
        if (word1.charAt(i) == word2.charAt(j)) {
            return memorization(word1, word2, i + 1, j + 1, result);
        }

        // Otherwise try 3 operations
        int insert = 1 + memorization(word1, word2, i, j + 1, result);
        int delete = 1 + memorization(word1, word2, i + 1, j, result);
        int replace = 1 + memorization(word1, word2, i + 1, j + 1, result);

        return result[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    public static int recursion(String word1, String word2) {
        return recursion(word1, word2, 0, 0);
    }

    private static int recursion(String word1, String word2, int i, int j) {

        // If word1 finished → insert remaining word2 chars
        if (i == word1.length()) {
            return word2.length() - j;
        }

        // If word2 finished → delete remaining word1 chars
        if (j == word2.length()) {
            return word1.length() - i;
        }

        // If characters match → move both
        if (word1.charAt(i) == word2.charAt(j)) {
            return recursion(word1, word2, i + 1, j + 1);
        }

        // Otherwise try 3 operations
        int insert = 1 + recursion(word1, word2, i, j + 1);
        int delete = 1 + recursion(word1, word2, i + 1, j);
        int replace = 1 + recursion(word1, word2, i + 1, j + 1);

        return Math.min(insert, Math.min(delete, replace));
    }
}
