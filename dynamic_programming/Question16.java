package dynamic_programming;

import java.util.Arrays;

public class Question16 {
    public static int recursion(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return recursion(satisfaction, 0, 1);
    }

    private static int recursion(int[] satisfaction, int index, int time) {
        if (index >= satisfaction.length) {
            return 0;
        }

        int takeIt = time * satisfaction[index] + recursion(satisfaction, index + 1, time + 1);
        int notTakeIt = recursion(satisfaction, index + 1, time);

        return Math.max(takeIt, notTakeIt);
    }

    public static int memorization(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] result = new int[satisfaction.length][satisfaction.length + 1];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }

        return memorization(satisfaction, 0, 1, result);
    }

    private static int memorization(int[] satisfaction, int index, int time, int[][] result) {
        if (index >= satisfaction.length) {
            return 0;
        }

        if (result[index][time] != -1) {
            return result[index][time];
        }

        int takeIt = time * satisfaction[index] + memorization(satisfaction, index + 1, time + 1, result);
        int notTakeIt = memorization(satisfaction, index + 1, time, result);

        return result[index][time] = Math.max(takeIt, notTakeIt);
    }

    public static int tabulation(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] result = new int[satisfaction.length + 1][satisfaction.length + 2];
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            for (int j = satisfaction.length; j > 0; j--) {
                int takeIt = j * satisfaction[i] + result[i + 1][j + 1];
                int notTakeIt = result[i + 1][j];

                result[i][j] = Math.max(takeIt, notTakeIt);
            }
        }

        return result[0][1];
    }

    public static int spaceOptimized(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;

        // We only need the "next" row to calculate the "current" row
        int[] next = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[n + 2];
            for (int j = i + 1; j >= 1; j--) {
                int takeIt = (j * satisfaction[i]) + next[j + 1];
                int notTakeIt = next[j];

                curr[j] = Math.max(takeIt, notTakeIt);
            }
            next = curr; // The current row becomes the 'next' row for the next dish
        }

        return next[1];
    }
}
