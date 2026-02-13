package dynamic_programming;

import java.util.Arrays;

public class Question32 {

    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, reversed);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return spaceOptimization(text1, text2);
    }

    public static int spaceOptimization(String text1, String text2) {
        int[] prev = new int[text2.length() + 1];

        int[] current = new int[text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    current[j] = 1 + prev[j + 1];
                } else {
                    current[j] = Math.max(prev[j], current[j + 1]);
                }
            }

            for (int k = 0; k < text2.length() + 1; k++) {
                prev[k] = current[k];
            }
        }
        return current[0];
    }

    public static int tabulation(String text1, String text2) {
        int[][] result = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    result[i][j] = 1 + result[i + 1][j + 1];
                } else {
                    result[i][j] = Math.max(result[i + 1][j], result[i][j + 1]);
                }
            }
        }
        return result[0][0];
    }

    public static int memorization(String text1, String text2) {
        int[][] result = new int[text1.length() + 1][text2.length() + 1];

        for (int[] r : result) {
            Arrays.fill(r, -1);
        }

        return memorization(text1, text2, 0, 0, result);
    }

    private static int memorization(String text1, String text2, int i, int j, int[][] result) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (result[i][j] != -1) {
            return result[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return result[i][j] = 1 + memorization(text1, text2, i + 1, j + 1, result);
        } else {
            return result[i][j] = Math.max(memorization(text1, text2, i + 1, j, result),
                    memorization(text1, text2, i, j + 1, result));
        }
    }

    public static int recursion(String text1, String text2) {
        return recursion(text1, text2, 0, 0);
    }

    private static int recursion(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + recursion(text1, text2, i + 1, j + 1);
        } else {
            return Math.max(recursion(text1, text2, i + 1, j), recursion(text1, text2, i, j + 1));
        }
    }

}
