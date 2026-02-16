package dynamic_programming;

import java.util.Arrays;

public class Question29 {
    public int maxProfit(int[] prices) {
        return spaceOptimiztion(prices);
    }

    public static int spaceOptimiztion(int[] prices) {
        int[][] current = new int[2][3];
        int[][] prev = new int[2][3];
        int n = prices.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {
                        current[buy][cap] = Math.max(
                                -prices[i] + prev[0][cap],
                                prev[1][cap]);
                    } else {
                        current[buy][cap] = Math.max(
                                prices[i] + prev[1][cap - 1],
                                prev[0][cap]);
                    }
                }
            }
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 3; c++) {
                    prev[b][c] = current[b][c];
                }
            }
        }

        return current[1][2];
    }

    public static int tabulation(int[] prices) {
        int n = prices.length;

        int[][][] result = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {
                        result[i][buy][cap] = Math.max(
                                -prices[i] + result[i + 1][0][cap],
                                result[i + 1][1][cap]);
                    } else {
                        result[i][buy][cap] = Math.max(
                                prices[i] + result[i + 1][1][cap - 1],
                                result[i + 1][0][cap]);
                    }
                }
            }
        }

        return result[0][1][2];
    }

    public static int memorization(int[] prices) {
        int[][][] result = new int[prices.length][2][3];
        for (int[][] data : result) {
            for (int[] d : data) {
                Arrays.fill(d, -1);
            }
        }

        return memorization(prices, 1, 0, 2, result);
    }

    private static int memorization(int[] prices, int buy, int index, int maxT, int[][][] result) {
        if (index >= prices.length || maxT == 0) {
            return 0;
        }

        if (result[index][buy][maxT] != -1) {
            return result[index][buy][maxT];
        }

        int max = 0;
        if (buy != 0) {
            int buy1 = -prices[index] + memorization(prices, buy - 1, index + 1, maxT, result);
            int notBuy = memorization(prices, buy, index + 1, maxT, result);
            max = Math.max(buy1, notBuy);
        } else {
            int sell = prices[index] + memorization(prices, buy + 1, index + 1, maxT - 1, result);
            int notSell = memorization(prices, buy, index + 1, maxT, result);
            max = Math.max(sell, notSell);
        }

        return result[index][buy][maxT] = max;
    }

    public static int recursion(int[] prices) {
        return recursion(prices, 1, 0, 2);
    }

    private static int recursion(int[] prices, int buy, int index, int maxT) {
        if (index >= prices.length || maxT == 0) {
            return 0;
        }

        int max = 0;
        if (buy != 0) {
            int buy1 = -prices[index] + recursion(prices, buy - 1, index + 1, maxT);
            int notBuy = recursion(prices, buy, index + 1, maxT);
            max = Math.max(buy1, notBuy);
        } else {
            int sell = prices[index] + recursion(prices, buy + 1, index + 1, maxT - 1);
            int notSell = recursion(prices, buy, index + 1, maxT);
            max = Math.max(sell, notSell);
        }

        return max;
    }

}
