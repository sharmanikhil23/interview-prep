package dynamic_programming;

import java.util.Arrays;

public class Question20 {
    public static int mod = (int) Math.pow(10, 9) + 7;
    public static int result = 0;

    public int numRollsToTarget(int n, int k, int target) {
        return spaceOptimization(n, k, target);
    }

    public static int spaceOptimization(int n, int k, int target) {
        int[] prev = new int[target + 1];
        prev[0] = 1;
        int[] current = new int[target + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                long currentSum = 0;
                for (int face = 1; face <= k; face++) {
                    if (j - face >= 0) {
                        currentSum = (currentSum + prev[j - face]) % mod;
                    }
                }
                current[j] = (int) currentSum;

            }
            prev = Arrays.copyOf(current, current.length);
        }
        return current[target];
    }

    public static int tabulation(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                long currentSum = 0;
                for (int face = 1; face <= k; face++) {
                    if (j - face >= 0) {
                        currentSum = (currentSum + dp[i - 1][j - face]) % mod;
                    }
                }
                dp[i][j] = (int) currentSum;

            }
        }
        return dp[n][target];
    }

    public static int memorization(int n, int k, int target) {
        int[][] tempResult = new int[n + 1][target + 1];

        for (int[] d : tempResult) {
            Arrays.fill(d, -1);
        }

        return memorization(n, k, target, tempResult);
    }

    public static int memorization(int n, int k, int target, int[][] tempResult) {
        if (n == 0 && target == 0) {
            return 1;
        }

        if (target < 0 || n < 0)
            return 0;

        if (tempResult[n][target] != -1) {
            return tempResult[n][target] % mod;
        }

        int sum = 0;

        for (int j = 1; j <= k; j++) {
            int newTarget = target - j;

            if (newTarget >= 0) {
                sum = (sum + memorization(n - 1, k, target - j, tempResult)) % mod;
            }
        }

        return tempResult[n][target] = sum % mod;
    }

    public static int recursion(int n, int k, int target) {
        if (n == 0 && target == 0) {
            return 1;
        }

        if (target < 0 || n < 0)
            return 0;

        int result = 0;

        for (int j = 0; j < k; j++) {
            int newTarget = target - j;

            if (newTarget >= 0) {
                result = (result + recursion(n - 1, k, newTarget)) % mod;
            }
        }

        return result % mod;
    }
}
