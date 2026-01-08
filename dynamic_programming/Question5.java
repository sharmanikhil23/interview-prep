package dynamic_programming;

import java.util.Arrays;

public class Question5 {
    public static int recursion(int[] data) {
        return recursion(data, 0);
    }

    private static int recursion(int[] data, int index) {
        if (index >= data.length) {
            return 0;
        }

        int takeIT = data[index] + recursion(data, index + 2);
        int notTakeIt = recursion(data, index + 1);

        return Math.max(takeIT, notTakeIt);
    }

    public static int memorization(int[] data) {
        int[] result = new int[data.length];
        Arrays.fill(result, -1);
        return memorization(data, 0, result);
    }

    private static int memorization(int[] data, int index, int[] result) {
        if (index >= data.length) {
            return 0;
        }

        if (result[index] != -1) {
            return result[index];
        }
        int takeIT = data[index] + memorization(data, index + 2, result);
        int notTakeIt = memorization(data, index + 1, result);

        return result[index] = Math.max(takeIT, notTakeIt);
    }
    
    public static int spaceOptimization(int[] data) {
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 2) {
            return Math.max(data[0], data[1]);
        } else {
            int first = data[0];
            int second = Math.max(data[0], data[1]);
            for (int i = 2; i < data.length; i++) {
                int takeIt = data[i] + first;
                int notTakeIt = second;
                first = second;
                second = Math.max(takeIt, notTakeIt);
            }
            return second;
        }
    }


    public static int tabulation(int[] data) {
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 2) {
            return Math.max(data[0], data[1]);
        } else {
            int[] result = new int[data.length + 1];
            result[1] = data[0];
            result[2] = Math.max(data[0], data[1]);
            for (int i = 3; i < result.length; i++) {
                int takeIt = data[i - 1] + result[i - 2];
                int notTakeIt = result[i - 1];
                result[i] = Math.max(takeIt, notTakeIt);
            }
            return result[data.length];
        }
    }



}
