package dynamic_programming;

import java.util.Arrays;

public class Question26 {

    public int mctFromLeafValues(int[] arr) {
        return tabulation1(arr);
    }

    public int tabulation1(int[] arr) {
        int n = arr.length;

        // 1. Pre-calculate max values for all ranges [i, j] - O(N^2)
        int[][] maxVal = new int[n][n];
        for (int i = 0; i < n; i++) {
            int currentMax = arr[i];
            for (int j = i; j < n; j++) {
                currentMax = Math.max(currentMax, arr[j]);
                maxVal[i][j] = currentMax;
            }
        }

        // 2. DP Table - O(N^3)
        int[][] dp = new int[n][n];

        // len is the length of the interval
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    // Use the pre-calculated maxVal instead of calling a function
                    int rootValue = maxVal[i][k] * maxVal[k + 1][j];
                    int totalCost = rootValue + dp[i][k] + dp[k + 1][j];

                    dp[i][j] = Math.min(dp[i][j], totalCost);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static int tabulation(int[] data) {
        int[][] result = new int[data.length + 1][data.length + 1];

        for (int i = data.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < data.length; j++) {
                int ans = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    ans = Math.min(ans, max(i, k, data) * max(k + 1, j, data) + result[i][k] + result[k + 1][j]);
                }
                result[i][j] = ans;
            }

        }
        return result[0][data.length - 1];

    }

    public static int memorization(int[] arr) {
        int[][] result = new int[arr.length][arr.length];

        for (int[] r : result) {
            Arrays.fill(r, -1);
        }

        return memorization(arr, 0, arr.length - 1, result);
    }

    private static int memorization(int[] data, int start, int end, int[][] result) {
        if (start >= end) {
            return 0;
        }

        if (result[start][end] != -1) {
            return result[start][end];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            ans = Math.min(ans, max(start, i, data) * max(i + 1, end, data) + memorization(data, start, i, result)
                    + memorization(data, i + 1, end, result));
        }

        return result[start][end] = ans;
    }

    public static int recursion(int[] arr) {

        return recursion(arr, 0, arr.length - 1);
    }

    private static int recursion(int[] data, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            ans = Math.min(ans, max(start, i, data) * max(i + 1, end, data) + recursion(data, start, i)
                    + recursion(data, i + 1, end));
        }

        return ans;
    }

    private static int max(int start, int end, int[] data) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, data[i]);
        }
        return max;
    }

}
