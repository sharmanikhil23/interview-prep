package dynamic_programming;

import java.util.Arrays;

public class Question14 {

    public static int recursion(int[] values) {
        return recursion(values, 0, values.length - 1);
    }

    private static int recursion(int[] values, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int temp = values[i] * values[j] * values[k] + recursion(values, i, k) + recursion(values, k, j);
            min = Math.min(temp, min);
        }

        return min;
    }

    public static int memorization(int[] values) {
        int[][] result = new int[values.length + 1][values.length + 1];

        for (int[] r : result) {
            Arrays.fill(r, -1);
        }

        return memorization(values, 0, values.length - 1, result);
    }

    private static int memorization(int[] values, int i, int j, int[][] result) {
        if (i + 1 == j) {
            return 0;
        } else if (result[i][j] != -1) {
            return result[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int temp = values[i] * values[j] * values[k] + memorization(values, i, k, result)
                    + memorization(values, k, j, result);
            min = Math.min(temp, min);
        }

        return result[i][j] = min;
    }

    public static int tabulation(int[] values) {
        int n = values.length;

        int[][] result = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int temp = values[i] * values[j] * values[k] + result[i][k] + result[k][j];
                    min = Math.min(min, temp);
                }
                result[i][j] = min;
            }
        }
        return result[0][n - 1];
    }
}
