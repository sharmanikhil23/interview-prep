package dynamic_programming;

import java.util.Arrays;

public class Question6 {
    public static int recursion(int length, int x, int y, int z) {
        if (length == 0) {
            return 0;
        } else if (length < 0) {
            return Integer.MIN_VALUE;
        } else {
            int first = 1 + recursion(length - x, x, y, z);
            int second = 1 + recursion(length - y, x, y, z);
            int third = 1 + recursion(length - z, x, y, z);

            return Math.max(first, Math.max(second, third));
        }
    }

    public static int memorization(int length, int x, int y, int z) {
        int[] result = new int[length + 1];
        Arrays.fill(result, -1);
        int r = memorization(length, x, y, z, result);
        return r < 0 ? 0 : r;
    }

    private static int memorization(int length, int x, int y, int z, int[] result) {
        if (length == 0) {
            return 0;
        } else if (length < 0) {
            return Integer.MIN_VALUE;
        } else if (result[length] != -1) {
            return result[length];
        } else {
            int first = 1 + memorization(length - x, x, y, z, result);
            int second = 1 + memorization(length - y, x, y, z, result);
            int third = 1 + memorization(length - z, x, y, z, result);

            return result[length] = Math.max(first, Math.max(second, third));
        }
    }
    
    public static int tabulation(int length, int x, int y, int z) {
        int[] result = new int[length + 1];

        int[] cuts = { x, y, z };
        
        for (int i = 1; i <= length; i++) {
            int temp = Integer.MIN_VALUE;
            for (int cut : cuts) {
                if (i - cut >= 0 && result[i - cut] >= 0) {
                    temp = Math.max(temp, 1 + result[i - cut]);
                }
            }
            result[i] = temp;
        }

        return result[length] == Integer.MIN_VALUE ? 0 : result[length];
    }
    
}
