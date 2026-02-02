package dynamic_programming;

import java.util.Arrays;

public class Question24 {
    public int numTrees(int n) {
        return tabulation(n);
    }

    public static int tabulation(int n) {

        if (n <= 1) {
            return 1;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            int ans = 0;
            for (int j = 1; j <= i; j++) {
                ans += (result[j - 1] * result[i - j]);
            }
            result[i] = ans;
        }

        return result[n];

    }

    public static int memorization(int n) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        return memorization(result, n);
    }

    public static int memorization(int[] result, int n) {
        if (n <= 1) {
            return 1;
        }

        if (result[n] != -1) {
            return result[n];
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += memorization(result, i - 1) * memorization(result, n - i);
        }
        return result[n] = ans;
    }

    public static int recursion(int n) {
        if (n <= 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += recursion(i - 1) * recursion(n - i);
        }
        return ans;
    }
}
