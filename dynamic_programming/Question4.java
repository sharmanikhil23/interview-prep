package dynamic_programming;

import java.util.Arrays;

public class Question4 {
    public static int recursion(int[] data) {
        return recursion(data, 0);
    }
    
    private static int recursion(int[] data, int index) {
        if (index >= data.length) {
            return 0;
        }

        int no = recursion(data, index + 1);
        int yes = data[index] + recursion(data, index + 2);

        return Math.max(no, yes);
    }

    public static int memorization(int[] data) {
        int[] result = new int[data.length + 1];
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

        int no = memorization(data, index + 1, result);
        int yes = data[index] + memorization(data, index + 2, result);

        return result[index] = Math.max(no, yes);
    }
    
    public static int tabulation(int[] data) {
        if (data.length == 0) {
            return 0;
        } else if (data.length == 1) {
            return data[0];
        }

        int[] result = new int[data.length + 1];
        result[0] = 0; // no data
        result[1] = data[0]; // if only 1 element
        result[2] = Math.max(data[0], data[1]); // if 2 element

        for (int i = 3; i < result.length; i++) {
            int no = result[i - 1];
            int yes = data[i - 1] + result[i - 2];
            result[i] = Math.max(yes, no);
        }

        return result[data.length];
    }
    
    public static int spaceOptimization(int[] data) {
         if (data.length == 0) {
            return 0;
        } else if (data.length == 1) {
            return data[0];
        } else {
            int first = data[0];
            int second = Math.max(data[0], data[1]);
            for (int i = 2; i < data.length; i++) {
                int no = second;
                int yes = data[i] + first;
                first = second;
                second = Math.max(yes, no);
            }
            return second;
        }
        
    }
    
}
