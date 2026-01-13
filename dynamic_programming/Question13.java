package dynamic_programming;

import java.util.Arrays;

public class Question13 {

    static int max = 0;

    public static int recursion(char[][] matrix) {
        max = 0;
        recursion(0, 0, matrix);
        return max * max;
    }

    private static int recursion(int i, int j, char[][] matrix) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        int right = recursion(i, j + 1, matrix);
        int down = recursion(i + 1, j, matrix);
        int diag = recursion(i + 1, j + 1, matrix);

        if (matrix[i][j] == '1') {
            int temp = 1 + Math.min(right, Math.min(down, diag));
            max = Math.max(max, temp);
            return temp;
        }

        return 0;
    }

    public static int memorization(char[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int[] t : temp) {
            Arrays.fill(t, -1);
        }
        max = 0;
        memorization(0, 0, matrix, temp);
        return max * max;
    }

    private static int memorization(int i, int j, char[][] matrix, int[][] temp) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        if (temp[i][j] != -1) {
            return temp[i][j];
        }

        int right = memorization(i, j + 1, matrix, temp);
        int down = memorization(i + 1, j, matrix, temp);
        int diag = memorization(i + 1, j + 1, matrix, temp);

        if (matrix[i][j] == '1') {
            int t = 1 + Math.min(right, Math.min(down, diag));
            max = Math.max(max, t);
            return temp[i][j] = t;
        }

        return temp[i][j] = 0;
    }

    public static int tabulation(char[][] matrix) {
        max = 0;
        int maxX = matrix.length;
        int maxY = matrix[0].length;

        int[][] temp = new int[maxX + 1][maxY + 1];

        for (int i = maxX - 1; i >= 0; i--) {
            for (int y = maxY - 1; y >= 0; y--) {

                if (matrix[i][y] == '1') {
                    int right = temp[i][y + 1];
                    int down = temp[i + 1][y];
                    int diag = temp[i + 1][y + 1];
                    int t = 1 + Math.min(right, Math.min(down, diag));
                    temp[i][y] = t;
                    max = Math.max(max, t);
                }
            }
        }

        return max * max;
    }

    public static int spaceOptimization(char[][] matrix) {
        max = 0;
        int maxX = matrix.length;
        int maxY = matrix[0].length;

        int[] dp = new int[maxY + 1];
        for (int i = maxX - 1; i >= 0; i--) {

            int diag = 0;

            for (int y = maxY - 1; y >= 0; y--) {
                int temp = dp[y];
                if (matrix[i][y] == '1') {
                    int t = 1 + Math.min(diag, Math.min(dp[y], dp[y + 1]));
                    dp[y] = t;
                    max = Math.max(max, t);
                } else {
                    dp[y] = 0;
                }
                diag = temp;
            }
        }

        return max * max;

    }
}
