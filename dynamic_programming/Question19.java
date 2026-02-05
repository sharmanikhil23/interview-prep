package dynamic_programming;

import java.util.Arrays;

public class Question19 {
    public static int recursion(int[] data) {
        int n = data.length;
        return Math.max(recursion(data, 0, n / 3, n - 2), recursion(data, 1, n / 3, n - 1));
    }

    public static int recursion(int[] data, int index, int n, int end) {
        if (n == 0 || index > end) {
            return 0;
        }

        int takeIt = data[index] + recursion(data, index + 2, n - 1, end);
        int notTakeIt = recursion(data, index + 1, n, end);
        return Math.max(takeIt, notTakeIt);

    }

    public static int memorization(int[] data) {
        int n = data.length;
        int[][] result = new int[n][(n / 3) + 1];

        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        int case1 = memorization(data, 0, n / 3, n - 2, result);

        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        int case2 = memorization(data, 1, n / 3, n - 1, result);

        return Math.max(case1, case2);
    }

    public static int memorization(int[] data, int index, int n, int end, int[][] result) {
        if (n == 0 || index > end) {
            return 0;
        }

        if (result[index][n] != -1) {
            return result[index][n];
        }

        int takeIt = data[index] + memorization(data, index + 2, n - 1, end, result);
        int notTakeIt = memorization(data, index + 1, n, end, result);
        return result[index][n] = Math.max(takeIt, notTakeIt);

    }

    public static int tabulation(int[] slices) {
        int n = slices.length;
        int[][] result = new int[n + 2][(n / 3) + 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = (n / 3); j >= 1; j--) {
                int takeIt = slices[i] + result[i + 2][j - 1];
                int notTakeIt = result[i + 1][j];
                result[i][j] = Math.max(takeIt, notTakeIt);
            }
        }

        int[][] result1 = new int[n + 2][(n / 3) + 1];

        for (int i = n - 1; i >= 1; i--) {
            for (int j = (n / 3); j >= 1; j--) {
                int takeIt = slices[i] + result1[i + 2][j - 1];
                int notTakeIt = result1[i + 1][j];
                result1[i][j] = Math.max(takeIt, notTakeIt);
            }
        }

        return Math.max(result[0][n / 3], result1[1][n / 3]);
    }

    public static int spaceOptimization(int[] slices) {
        int n = slices.length;
        int k = n / 3;

        // Case 1: Indices 0 to n-2
        int case1 = spaceOptimization(slices, 0, n - 2, k);
        // Case 2: Indices 1 to n-1
        int case2 = spaceOptimization(slices, 1, n - 1, k);

        return Math.max(case1, case2);
    }

    private static int spaceOptimization(int[] slices, int start, int end, int k) {
        // We only need three rows of size k+1
        int[] curr = new int[k + 1];
        int[] next = new int[k + 1];
        int[] nextNext = new int[k + 1];

        for (int i = end; i >= start; i--) {
            for (int j = 1; j <= k; j++) {
                int takeIt = slices[i] + nextNext[j - 1];
                int notTakeIt = next[j];

                curr[j] = Math.max(takeIt, notTakeIt);
            }
            // Shift the "rows" backward
            // System.arraycopy is more efficient than manual loops
            System.arraycopy(next, 0, nextNext, 0, k + 1);
            System.arraycopy(curr, 0, next, 0, k + 1);
        }

        return next[k]; // After the last iteration, 'next' holds the result for the start index
    }

}
