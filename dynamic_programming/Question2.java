package dynamic_programming;

import java.util.Arrays;

public class Question2 {
    public static int recursion(int[] cost) {
        return Math.min(recursion(cost, 0), recursion(cost, 1));
    }

    private static int recursion(int[] cost, int index) {
        // already left the top
        if (index > cost.length - 1) {
            return 0;
        } else if (index == cost.length - 1) {
            return cost[index];
        } else {
            return cost[index] + Math.min(recursion(cost, index + 1), recursion(cost, index + 2));
        }
    }
    
    public static int memorization(int[] cost) {
        int[] result = new int[cost.length + 1];
        Arrays.fill(result, -1);
        int left = memorization(cost, 0, result);
        Arrays.fill(result, -1);
        int right = memorization(cost, 1, result);
        return Math.min(left,right);
    }

    private static int memorization(int[] cost, int index, int[] result) {
        // already left the top
        if (index > cost.length - 1) {
            return 0;
        } else if (index == cost.length - 1) {
            return cost[index];
        } else if (result[index] != -1) {
            return result[index];
        } else {
            return result[index] = cost[index]
                    + Math.min(memorization(cost, index + 1, result), memorization(cost, index + 2, result));
        }
    }
    
    public static int tabulation(int[] n) {
        int[] result = new int[n.length];
        result[0] = n[0];
        result[1] = n[1];

        for (int i = 2; i < n.length; i++) {
            result[i] = Math.min(result[i - 1], result[i - 2]) + n[i];
        }

        return Math.min(result[result.length - 2], result[result.length - 1]);
    }
    
    public static int spaceOptimization(int[] n) {
        int first = n[0];
        int second = n[1];
        int result;

        for(int i=2;i<n.length;i++){
            result = Math.min(first, second) + n[i];
            first = second;
            second = result;
        }

        return Math.min(first,second);
    }
    
}
