package dynamic_programming;

import java.util.Arrays;

public class Question10 {
    public static int recursion(int w, int val[], int wt[]) {
        return recursion(w, val, wt, 0);
    }

    private static int recursion(int w, int val[], int wt[], int index) {
        if (index >= val.length) {
            return 0;
        } else if (w <= 0) {
            return 0;
        } else {
            int takeIt = 0;
            if (wt[index] <= w) {
                takeIt = val[index] + recursion(w - wt[index], val, wt, index + 1);
                ;
            }

            int ignoreIt = recursion(w, val, wt, index + 1);

            return Math.max(takeIt, ignoreIt);
        }
    }
    
    public static int memorization(int w, int val[], int wt[]) {
        int[][] result = new int[w + 1][val.length + 1];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        return memorization(w, val, wt, 0, result);
    }

    private static int memorization(int w, int val[], int wt[], int index,int[][] result
    ) {
        if (index >= val.length) {
            return 0;
        } else if (w <= 0) {
            return 0;
        } else if (result[w][index] != -1) {
            return result[w][index];
        } else {
            int takeIt = 0;
            if (wt[index] <= w) {
                takeIt = val[index] + memorization(w - wt[index], val, wt, index + 1, result);
            }

            int ignoreIt = memorization(w, val, wt, index + 1, result);

            return result[w][index] = Math.max(takeIt, ignoreIt);
        }
    }
    
    // This works but become hard to further optimize as it depend now on variable rows which is bad so switch it use index as rows and weight as columns
    public static int tabulation(int w, int val[], int wt[]) {
        int[][] result = new int[w + 1][val.length + 1];
        for (int i = 0; i < w + 1; i++) {
            for (int j = 0; j < val.length + 1; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                } else {
                    int take = 0;
                    if (wt[j - 1] <= i) {
                        take = val[j - 1] + result[i - wt[j - 1]][j - 1];
                    }
                    int notTake = result[i][j - 1];

                    result[i][j] = Math.max(take, notTake);
                }
            }
        }
        return result[w][val.length];
    }

    // now in this one as result is just depend on the one above it so 
    public static int tabulation1(int w, int val[], int wt[]) {
        int[][] result = new int[val.length + 1][w + 1];
        // first loop is for index and second is for the weight
        for (int i = 0; i < val.length + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                } else {
                    int take = 0;
                    if (wt[i - 1] <= j) {
                        take = val[i - 1] + result[i-1][j - wt[i - 1]];
                    }
                    int notTake = result[i-1][j];

                    result[i][j] = Math.max(take, notTake);
                }
            }
        }
        return result[val.length][w];
    }

    public static int spaceOptimizationTwoArrays(int w, int val[], int wt[]) {
    // prev represents result[i-1], curr represents result[i]
    int[] prev = new int[w + 1];
    int[] curr = new int[w + 1];

    for (int i = 1; i <= val.length; i++) {
        for (int j = 1; j <= w; j++) {
            int take = 0;
            if (wt[i - 1] <= j) {
                // Look at the previous row (prev) for the remaining capacity
                take = val[i - 1] + prev[j - wt[i - 1]];
            }
            // Look at the previous row (prev) for the 'notTake' case
            int notTake = prev[j];

            curr[j] = Math.max(take, notTake);
        }
        // Very Important: Copy current row to previous row for the next item
        // Or simply: prev = curr.clone(); 
        // Better yet, just swap references to avoid extra copying:
        System.arraycopy(curr, 0, prev, 0, w + 1);
    }
    return prev[w];
}
    public static int spaceOptimized(int w, int val[], int wt[]) {
    int[] dp = new int[w + 1];

    for (int i = 0; i < val.length; i++) {
        // Go backwards to ensure we use each item only once
        for (int cap = w; cap >= wt[i]; cap--) {
            dp[cap] = Math.max(dp[cap], val[i] + dp[cap - wt[i]]);
        }
    }
    return dp[w];
    }
    
}
