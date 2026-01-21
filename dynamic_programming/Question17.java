package dynamic_programming;

import java.util.Arrays;

public class Question17 {

    public static int recursion(int[] data) {
        return recursion(data, 0, -1);
    }

    public static int recursion(int[] data, int index, int prev) {
        if (data.length == index) {
            return 0;
        }

        int include = 0;
        if (prev == -1) {
            include = 1 + recursion(data, index + 1, index);
        } else if (prev != -1 && data[prev] < data[index]) {
            include = 1 + recursion(data, index + 1, index);
        }

        int exclude = recursion(data, index + 1, prev);

        return Math.max(include, exclude);

    }

    public static int memorization(int[] data) {
        int result[][] = new int[data.length][data.length];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        return memorization(data, 0, -1, result);
    }

    public static int memorization(int[] data, int index, int prev, int[][] result) {
        if (data.length == index) {
            return 0;
        }

        if (prev != -1 && result[index][prev] != -1) {
            return result[index][prev];
        }

        int include = 0;
        if (prev == -1) {
            include = 1 + memorization(data, index + 1, index, result);
        } else if (prev != -1 && data[prev] < data[index]) {
            include = 1 + memorization(data, index + 1, index, result);
        }

        int exclude = memorization(data, index + 1, prev, result);

        int r = Math.max(include, exclude);

        if (prev != -1) {
            result[index][prev] = r;
        }

        return r;
    }

    public static int tabulation(int[] data) {
        int n = data.length;

        int[][] result = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int include = 0;
                if (j == -1) {
                    include = 1 + result[i + 1][i + 1];
                } else if (j != -1 && data[j] < data[i]) {
                    include = 1 + result[i + 1][i + 1];
                }

                int exclude = result[i + 1][j + 1];

                result[i][j + 1] = Math.max(include, exclude);
            }
        }

        return result[0][0];
    }

    public static int spaceOptimizedTabulation(int[] data) {
        int n = data.length;
        // We only need two rows: the 'next' row and the 'current' row
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                // Logic is the same, but we use next[] instead of result[i+1][]
                int exclude = next[j + 1];

                int include = 0;
                if (j == -1 || data[i] > data[j]) {
                    include = 1 + next[i + 1];
                }

                curr[j + 1] = Math.max(include, exclude);
            }
            // Move current row to next row for the next iteration of 'i'
            next = curr.clone();
        }

        return next[0];
    }

}
