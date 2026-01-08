package dynamic_programming;

import java.util.Arrays;

public class Question3 {
    public static int recursion(int[] data, int target) {
        int result = recur(data, target);
        return result != Integer.MAX_VALUE ? result : -1;
    }

    private static int recur(int[] data, int target) {
        if (target == 0) {
            return 0;
        } else if (target < 0) {
            return Integer.MAX_VALUE;
        } else {
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < data.length; i++) {
                int res = recur(data, target - data[i]);

                if (res != Integer.MAX_VALUE) {
                    result = Math.min(result,1 + res);
                }
            }
            return result;
        }
    }

    public static int memorization(int[] data, int target) {
        int[] results = new int[target + 1];
        Arrays.fill(results, -1);
        int result = memo(data, target, results);
        return result != Integer.MAX_VALUE ? result : -1;
    }

    private static int memo(int[] data, int target, int[] results) {
        if (target == 0) {
            return 0;
        } else if (target < 0) {
            return Integer.MAX_VALUE;
        } else if(results[target] != -1){
            return results[target];
        }else {
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < data.length; i++) {
                int res = memo(data, target - data[i],results);

                if (res != Integer.MAX_VALUE) {
                    result = Math.min(result, 1 + res);
                }
            }
            return results[target] = result;
        }
    }
    
    public static int tabulation(int[] data, int target) {
        int[] result = new int[target + 1];
        
        for (int i = 1; i < result.length; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < data.length; j++) {
                int newTarget = i - data[j];

                if (newTarget >= 0 && result[newTarget] != Integer.MAX_VALUE) {
                    temp = Math.min(temp, 1 + result[newTarget]);
                }
            }
            result[i] = temp;
        }

        return result[target];
    }

    
}
