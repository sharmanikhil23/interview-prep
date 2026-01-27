package dynamic_programming;

import java.util.Arrays;

public class Question11 {
    public static int recursion(int n) {
        if (n == 0) {
            return 0;
        }

        int max = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            max = Math.min(max, 1 + recursion(n - (i * i)));
        }

        return max;
    }

    public static int memorization(int n) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        return memorization(n, result);
    }

    private static int memorization(int n, int[] result) {
        if (n == 0) {
            return 0;
        } else if (result[n] != -1) {
            return result[n];
        } else {
            int max = Integer.MAX_VALUE;

            for (int i = 1; i * i <= n; i++) {
                max = Math.min(max, 1 + memorization(n - (i * i), result));
            }

            return result[n] = max;
        }
    }

    public static int tabulation(int n) {
        if (n < 4) {
            return n;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        for (int i = 4; i < result.length; i++) {
            int max = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                max = Math.min(max, 1 + result[(i - (j * j))]);
            }
            result[i] = max;
        }

        return result[n];
    }

}
