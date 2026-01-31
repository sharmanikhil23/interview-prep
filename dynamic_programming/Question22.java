package dynamic_programming;

import java.util.HashMap;

public class Question22 {
    public int longestArithSeqLength(int[] nums) {
        return spaceoptimization(nums);
    }

    /**
     * This is an excellent approach as now we know the size of an array will be
     * 1001*n
     * 
     * @param nums
     * @return
     */
    public int spaceoptimization(int[] nums) {
        int n = nums.length;
        // Assuming nums values are 0-500, diff is -500 to 500.
        // We use an offset of 500.
        int[][] dp = new int[n][1001];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500; // Offset logic
                // If dp[j][diff] is 0, it's a new pair (length 2)
                // If it's > 0, we extend the existing chain
                dp[i][diff] = (dp[j][diff] == 0) ? 2 : dp[j][diff] + 1;
                max = Math.max(max, dp[i][diff]);
            }
        }
        return max;
    }

    public static int tabulation(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;

        int maxLen = 0;

        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];

                // If we saw this diff at index j, extend it. Otherwise, it's a new pair (length
                // 2).
                int currentLen = dp[j].getOrDefault(diff, 1) + 1;

                dp[i].put(diff, currentLen);
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        return maxLen;
    }

    public static int memorization(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int ans = 0;
        HashMap<Integer, Integer>[] result = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = new HashMap<>();
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                ans = Math.max(ans, 2 + memorization(nums, diff, i, result));
            }
        }
        return ans;
    }

    private static int memorization(int[] nums, int diff, int index, HashMap<Integer, Integer>[] result) {
        if (index < 0) {
            return 0;
        }

        if (result[index].containsKey(diff)) {
            return result[index].get(diff);
        }

        int ans = 0;
        for (int i = index - 1; i >= 0; i--) {
            int tempDiff = nums[index] - nums[i];
            if (tempDiff == diff) {
                ans = Math.max(ans, 1 + memorization(nums, diff, i, result));
            }
        }

        result[index].put(diff, ans);
        return ans;
    }

    public static int recursion(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        } else {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int diff = nums[j] - nums[i];
                    ans = Math.max(ans, 2 + recursion(nums, diff, i));
                }
            }
            return ans;
        }
    }

    private static int recursion(int[] nums, int diff, int index) {
        if (index < 0) {
            return 0;
        }

        int ans = 0;
        for (int i = index - 1; i >= 0; i--) {
            int tempDiff = nums[index] - nums[i];
            if (tempDiff == diff) {
                ans = Math.max(ans, 1 + recursion(nums, diff, i));
            }
        }

        return ans;
    }
}
