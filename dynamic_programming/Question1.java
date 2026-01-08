package dynamic_programming;

import java.util.Arrays;

public class Question1 {

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    /**
     * This is using memorization
     * @param n
     * @return
     */
    public static int fibonacciMemorization(int n) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        return fibonacciMemorization(n, result);
    }

    private static int fibonacciMemorization(int n, int[] result) {
        if (n == 0 || n == 1) {
            return n;
        } else if (result[n] != -1) {
            return result[n];
        } else {
            return result[n] = fibonacciMemorization(n-1, result) + fibonacciMemorization(n-2,result);
        }
    }
    

    /**
     * This is using tabulation mean bottom up
     */
    public static int tabulation(int n) {
        int[] result = new int[n + 1];
        result[1] = 1;

        for (int i = 2; i < n + 1; i++)
            result[i] = result[i - 1] + result[i - 2];

        return result[n];
    }
    
    /**
     * This is space optimization
     */
    public static int spaceOptimization(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        int result = 0;

        for (int i = 2; i < n + 1; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return second;
    }
}
