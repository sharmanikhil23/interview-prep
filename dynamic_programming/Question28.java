package dynamic_programming;

import java.util.*;

public class Question28 {
    public int maxProfit(int[] prices) {
        return spaceOptimization(prices);
    }

    public static int spaceOptimization(int[] prices) {
        int n = prices.length;
        int[] current = new int[2];
        int[] prev = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int max = 0;
                if (j == 1) {
                    max = Math.max(-prices[i] + prev[0], prev[1]);
                } else {
                    max = Math.max(prices[i] + prev[1], prev[0]);
                }

                current[j] = max;
            }
            prev = current;
        }
        return current[1];
    }

    public static int tabulation(int[] prices) {
        int n = prices.length;

        int[][] result = new int[prices.length + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int max = 0;
                if (j == 1) {
                    max = Math.max(-prices[i] + result[i + 1][0], result[i + 1][1]);
                } else {
                    max = Math.max(prices[i] + result[i + 1][1], result[i + 1][0]);
                }

                result[i][j] = max;
            }
        }

        return result[0][1];
    }

    public static int memorization(int[] prices) {
        int[][] result = new int[prices.length + 1][2];
        for (int[] d : result) {
            Arrays.fill(d, -1);
        }
        return memorization(prices, 0, 1, result);
    }

    private static int memorization(int[] prices, int index, int canChoose, int[][] result) {
        if (index >= prices.length) {
            return 0;
        }

        if (result[index][canChoose] != -1) {
            return result[index][canChoose];
        }

        int max = 0;

        if (canChoose == 1) {
            max = Math.max(-prices[index] + memorization(prices, index + 1, 0, result),
                    memorization(prices, index + 1, 1, result));
        } else {
            max = Math.max(prices[index] + memorization(prices, index + 1, 1, result),
                    memorization(prices, index + 1, 0, result));
        }

        return result[index][canChoose] = max;
    }

    public static int recursion(int[] prices) {
        return recursion(prices, 0, 1);
    }

    private static int recursion(int[] prices, int index, int canChoose) {
        if (index >= prices.length) {
            return 0;
        }

        int max = 0;

        if (canChoose == 1) {
            max = Math.max(-prices[index] + recursion(prices, index + 1, 0), recursion(prices, index + 1, 1));
        } else {
            max = Math.max(prices[index] + recursion(prices, index + 1, 1), recursion(prices, index + 1, 0));
        }

        return max;
    }
}
