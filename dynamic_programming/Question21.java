package dynamic_programming;

import java.util.Arrays;

public class Question21 {
    public static boolean canPartition(int[] nums) {
        return spaceOptimization(nums);
    }

    public static boolean spaceOptimization(int[] data) {
        int temp = 0;

        for (int t : data) {
            temp += t;
        }

        if (temp % 2 != 0) {
            return false;
        } else {
            boolean[] prev = new boolean[(temp / 2) + 1];
            prev[0] = true;

            for (int i = data.length - 1; i >= 0; i--) {
                boolean[] current = new boolean[(temp / 2) + 1];
                current[0] = true;
                for (int j = 1; j <= temp / 2; j++) {
                    boolean takeIt = false;
                    if (j - data[i] >= 0)
                        takeIt = takeIt || prev[j - data[i]];
                    boolean notTakeIt = prev[j];

                    current[j] = takeIt || notTakeIt;
                }
                prev = Arrays.copyOf(current, current.length);
            }
            return prev[(temp / 2)];
        }
    }

    public static boolean tabulation(int[] data) {
        int temp = 0;

        for (int t : data) {
            temp += t;
        }

        if (temp % 2 != 0) {
            return false;
        } else {

            boolean[][] result = new boolean[data.length + 1][(temp / 2) + 1];
            // initlizing the base case if target = 0
            for (int i = 0; i < result.length; i++) {
                result[i][0] = true;
            }

            for (int i = data.length - 1; i >= 0; i--) {
                for (int j = 1; j <= temp / 2; j++) {
                    boolean takeIt = false;
                    if (j - data[i] >= 0)
                        takeIt = takeIt || result[i + 1][j - data[i]];
                    boolean notTakeIt = result[i + 1][j];

                    result[i][j] = takeIt || notTakeIt;
                }
            }
            return result[0][(temp / 2)];
        }
    }

    public static boolean memorization(int[] data) {
        int temp = 0;

        for (int t : data) {
            temp += t;
        }

        if (temp % 2 != 0) {
            return false;
        } else {
            int[][] result = new int[data.length + 1][(temp / 2) + 1];

            for (int[] t : result) {
                Arrays.fill(t, -1);
            }

            return memorization(data, temp / 2, 0, result) == 1 ? true : false;
        }
    }

    private static int memorization(int[] data, int target, int index, int[][] result) {

        if (target == 0)
            return 1;

        if (index >= data.length || target < 0)
            return 0;

        if (result[index][target] != -1) {
            return result[index][target];
        }

        int takeIt = memorization(data, target - data[index], index + 1, result);
        int notTakeIt = memorization(data, target, index + 1, result);

        return result[index][target] = Math.max(takeIt, notTakeIt);
    }

    public static boolean recursion(int[] data) {
        int temp = 0;

        for (int t : data) {
            temp += t;
        }

        if (temp % 2 != 0) {
            return false;
        } else {
            return recursion(data, temp / 2, 0);
        }
    }

    private static boolean recursion(int[] data, int target, int index) {

        if (target == 0)
            return true;

        if (index >= data.length || target < 0)
            return false;

        boolean takeIt = false || recursion(data, target - data[index], index + 1);
        boolean notTakeIt = false || recursion(data, target, index + 1);

        return takeIt || notTakeIt;
    }

}
