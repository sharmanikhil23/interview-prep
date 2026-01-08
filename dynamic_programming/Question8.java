package dynamic_programming;

import java.util.Arrays;

public class Question8 {
    public static int recursion(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k + (k * (k - 1));
        } else {
            return (k - 1) * (recursion(n - 1, k) + recursion(n - 2, k));
        }
    }
    
    public static int memorization(int n, int k) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        return memorization(n, k, result);
    }

    private static int memorization(int n, int k, int[] result) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k + (k * (k - 1));
        } else if (result[n] != -1) {
            return result[n];
        } else {
            return result[n] = (k - 1) * (memorization(n - 1, k, result) + memorization(n - 2, k, result));
        }
    }
    
    public static int tabulation(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k + (k * (k - 1));
        } else {
            int[] result = new int[n + 1];
            result[1] = k;
            result[2] = k + (k * (k - 1));

            for (int i = 3; i <= n; i++) {
                result[i] = (k - 1) * (result[i - 1] + result[i - 2]);
            }

            return result[n];
        }
    }

    public static int spaceOptimization(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k + (k * (k - 1));
        } else {
            int first = k;
            int second = k + (k * (k - 1));

            for (int i = 3; i <= n; i++) {
                int result = (k - 1) * (first + second);
                first = second;
                second = result;
            }

            return second;
        }
    }

}
