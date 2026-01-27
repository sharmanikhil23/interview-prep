package dynamic_programming;

import java.util.*;

public class Question9 {
    public static int recursion(int[] data, int target) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else {
            int result = 0;
            for (int i = 0; i < data.length; i++) {
                result += recursion(data, target - data[i]);
            }
            return result;
        }
    }

    public static int memorization(int[] data, int target) {
        int[] result = new int[target + 1];
        Arrays.fill(result, -1);
        return memorization(data, target, result);
    }

    private static int memorization(int[] data, int target, int[] result) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else if (result[target] != -1) {
            return result[target];
        } else {
            int r = 0;
            for (int i = 0; i < data.length; i++) {
                r += memorization(data, target - data[i], result);
            }
            return result[target] = r;
        }
    }

    public static int tabulation(int[] data, int target) {
        int[] result = new int[target + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            int temp = 0;
            for (int j = 0; j < data.length; j++) {
                if (i - data[j] >= 0) {
                    temp += result[i - data[j]];
                }
            }
            result[i] = temp;
        }
        return result[target];
    }

}
