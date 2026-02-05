package dynamic_programming;

public class Question27 {

    public static int recursion(int[] prices) {
        return recursion(prices, 0, -1);
    }

    private static int recursion(int[] data, int index, int prev) {
        if (index >= data.length) {
            return Integer.MIN_VALUE;
        }

        int result = Integer.MIN_VALUE;

        if (prev != -1) {
            int sellIt = data[index] - data[prev];
            int notSell = recursion(data, index + 1, prev);
            result = Math.max(result, Math.max(sellIt, notSell));
        } else {
            result = Math.max(result, recursion(data, index + 1, index));
            result = Math.max(result, recursion(data, index + 1, prev));
        }
        return result;
    }

    public static int tabulation(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - min;
            profit = Math.max(profit, diff);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }

}
