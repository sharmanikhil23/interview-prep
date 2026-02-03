package dynamic_programming;

public class Question25 {

    public int getMoneyAmount(int n) {
        return tabulation(n);
    }

    public static int tabulation(int n) {
        int[][] data = new int[n + 2][n + 2];

        for (int i = n; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    min = Math.min(min, k + Math.max(data[i][k - 1], data[k + 1][j]));
                }
                data[i][j] = min;
            }
        }

        return data[1][n];
    }

    public static int memorization(int n) {
        int[][] data = new int[n + 1][n + 1];

        for (int[] d : data) {
            Arrays.fill(d, -1);
        }

        return memorization(n, 1, n, data);
    }

    private static int memorization(int n, int start, int end, int[][] result) {
        if (start >= end) {
            return 0;
        }

        if (result[start][end] != -1) {
            return result[start][end];
        }

        int min = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            min = Math.min(min,
                    i + Math.max(memorization(n, start, i - 1, result), memorization(n, i + 1, end, result)));
        }

        return result[start][end] = min;
    }

    public static int recursion(int n) {
        return recursion(n, 1, n);
    }

    private static int recursion(int n, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            min = Math.min(min, i + Math.max(recursion(n, start, i - 1), recursion(n, i + 1, end)));
        }

        return min;
    }
}
