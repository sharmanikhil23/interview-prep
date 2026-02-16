package dynamic_programming;

import java.util.Arrays;

public class Question31 {

    public long maximumProfit(int[] prices, int k) {
        return spaceOptimization(prices, k);
    }

    public static long spaceOptimization(int[] prices, int k) {
        long[][] current = new long[k + 1][3];
        long[][] prev = new long[k + 1][3];

        int n = prices.length;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                for (int state = 0; state <= 2; state++) {
                    if (i == prices.length - 1) {
                        current[j][state] = state == 0 ? 0 : (state == 1 ? prices[i] : -prices[i]);
                        continue;
                    }

                    long result = 0;

                    // we do nothing
                    result = prev[j][state];

                    if (state == 0) {
                        long buy = -prices[i] + prev[j][1];
                        ;

                        long sh = prices[i] + prev[j][2];

                        result = Math.max(result, Math.max(buy, sh));
                    } else if (state == 1) {
                        // good to buy again
                        long sell = prices[i] + prev[j - 1][0];
                        result = Math.max(result, sell);
                    } else {
                        // buying back the short stock
                        long buy = -prices[i] + prev[j - 1][0];

                        result = Math.max(result, buy);
                    }

                    current[j][state] = result;
                }
            }
            for (int x = 0; x <= k; x++) {
                for (int y = 0; y <= 2; y++) {
                    prev[x][y] = current[x][y];
                }
            }
        }
        return prev[k][0];
    }

    public static long tabulation(int[] prices, int k) {
        long[][][] r = new long[prices.length + 1][k + 1][3];
        int n = prices.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                for (int state = 0; state <= 2; state++) {
                    if (i == prices.length - 1) {
                        r[i][j][state] = state == 0 ? 0 : (state == 1 ? prices[i] : -prices[i]);
                        continue;
                    }

                    long result = 0;

                    // we do nothing
                    result = r[i + 1][j][state];

                    if (state == 0) {
                        long buy = -prices[i] + r[i + 1][j][1];
                        ;

                        long sh = prices[i] + r[i + 1][j][2];

                        result = Math.max(result, Math.max(buy, sh));
                    } else if (state == 1) {
                        // good to buy again
                        long sell = prices[i] + r[i + 1][j - 1][0];
                        result = Math.max(result, sell);
                    } else {
                        // buying back the short stock
                        long buy = -prices[i] + r[i + 1][j - 1][0];

                        result = Math.max(result, buy);
                    }

                    r[i][j][state] = result;
                }
            }
        }
        return r[0][k][0];
    }

    public static long memorization(int[] prices, int k) {
        long[][][] r = new long[prices.length + 1][k + 1][3];

        for (long[][] r1 : r) {
            for (long[] r2 : r1) {
                Arrays.fill(r2, -1);
            }
        }
        return memorization(prices, k, 0, 0, r);
    }

    private static long memorization(int[] prices, int k, int index, int state, long[][][] r) {
        if (k == 0) {
            return 0;
        }

        if (index == prices.length - 1) {
            return state == 0 ? 0 : (state == 1 ? prices[index] : -prices[index]);
        }

        if (r[index][k][state] != -1) {
            return r[index][k][state];
        }

        long result = 0;

        // we do nothing
        result = memorization(prices, k, index + 1, state, r);

        if (state == 0) {
            long buy = -prices[index] + memorization(prices, k, index + 1, 1, r);

            long sh = prices[index] + memorization(prices, k, index + 1, 2, r);

            result = Math.max(result, Math.max(buy, sh));
        } else if (state == 1) {
            // good to buy again
            long sell = prices[index] + memorization(prices, k - 1, index + 1, 0, r);
            result = Math.max(result, sell);
        } else {
            // buying back the short stock
            long buy = -prices[index] + memorization(prices, k - 1, index + 1, 0, r);

            result = Math.max(result, buy);
        }

        return r[index][k][state] = result;
    }

    public static long recursion(int[] prices, int k) {
        return recursion(prices, k, 0, 0);
    }

    private static long recursion(int[] prices, int k, int index, int state) {
        if (k == 0) {
            return 0;
        }

        if (index == prices.length - 1) {
            return state == 0 ? 0 : (state == 1 ? prices[index] : -prices[index]);
        }

        long result = 0;

        // we do nothing
        result = recursion(prices, k, index + 1, state);

        if (state == 0) {
            long buy = -prices[index] + recursion(prices, k, index + 1, 1);

            long sh = prices[index] + recursion(prices, k, index + 1, 2);

            result = Math.max(result, Math.max(buy, sh));
        } else if (state == 1) {
            // good to buy again
            long sell = prices[index] + recursion(prices, k - 1, index + 1, 0);
            result = Math.max(result, sell);
        } else {
            // buying back the short stock
            long buy = -prices[index] + recursion(prices, k - 1, index + 1, 0);

            result = Math.max(result, buy);
        }

        return result;
    }

}
