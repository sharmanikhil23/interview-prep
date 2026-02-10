package dynamic_programming;

public class Question30 {
    public int maxProfit(int k, int[] prices) {
        return spaceOptimiztion(prices, k);
    }

    public static int spaceOptimiztion(int[] prices, int k) {
        int[][] current = new int[2][k + 1];
        int[][] prev = new int[2][k + 1];
        int n = prices.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {

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
                for (int c = 0; c <= k; c++) {
                    prev[b][c] = current[b][c];
                }
            }
        }

        return current[1][k];
    }
}
