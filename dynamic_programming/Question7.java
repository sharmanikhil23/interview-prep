package dynamic_programming;

import java.util.Arrays;

public class Question7 {
    public static int recursion(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return n - 1 * (recursion(n - 1) + recursion(n - 2));
        }
    }
    
    public static int memorization(int n) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        return memorization(n, result);
    }

    private static int memorization(int n, int[] result) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (result[n] != -1) {
            return result[n];
        } else {
            return result[n] = (n - 1) * (memorization(n - 1, result) + memorization(n - 2, result));
        }
    }

    public static int tabulation(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int[] result = new int[n + 1];
            result[2] = 1;

            for (int i = 3; i < result.length; i++) {
                result[i] = (i - 1) * (result[i - 1] + result[i - 2]);
            }

            return result[n];
        }
    }
    
    public static int spaceOptimization(int n) {
         if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int first = 0;
            int second = 1;
            for (int i = 3; i <= n; i++) {
                int result = (i - 1) * (first + second);
                first = second;
                second = result;
            }
            return second;
        }
    }
    
}
