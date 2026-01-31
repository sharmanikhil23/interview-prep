package dynamic_programming;

import java.util.HashMap;

public class Question23 {

    public int longestSubsequence(int[] arr, int difference) {
        return memorization(arr, difference);
    }

    public static int tabulation(int[] arr, int difference) {
        if (arr.length == 1) {
            return 1;
        } else {
            int result = 0;
            HashMap<Integer, Integer> temp = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int newElm = arr[i] - difference;
                result = Math.max(result, 1 + temp.getOrDefault(newElm, 0));

                temp.put(arr[i], 1 + temp.getOrDefault(newElm, 0));
            }
            return result;
        }
    }

    public int recursion(int[] arr, int difference) {
        int overallMax = 0;
        for (int i = 0; i < arr.length; i++) {
            overallMax = Math.max(overallMax, recursion(i, arr, difference));
        }
        return overallMax;
    }

    // Returns the longest subsequence ending exactly at 'index'
    private int recursion(int index, int[] arr, int difference) {
        int bestForMe = 1; // Base case: the element itself is a sequence of length 1

        // Look at all elements before the current one
        for (int prev = 0; prev < index; prev++) {
            if (arr[index] - arr[prev] == difference) {
                // If it matches the difference, extend that sequence
                bestForMe = Math.max(bestForMe, 1 + recursion(prev, arr, difference));
            }
        }
        return bestForMe;
    }

    public int memorization(int[] arr, int difference) {
        int overallMax = 0;
        // Map stores: Index -> Longest sequence ending at this index
        HashMap<Integer, Integer> memo = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            overallMax = Math.max(overallMax, solveMemo(i, arr, difference, memo));
        }
        return overallMax;
    }

    private int solveMemo(int index, int[] arr, int difference, HashMap<Integer, Integer> memo) {
        // 1. Check if we already calculated this index
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int bestForMe = 1;

        // 2. Look at all previous elements
        for (int prev = 0; prev < index; prev++) {
            if (arr[index] - arr[prev] == difference) {
                bestForMe = Math.max(bestForMe, 1 + solveMemo(prev, arr, difference, memo));
            }
        }

        // 3. Store in memo
        memo.put(index, bestForMe);
        return bestForMe;
    }

    public int spaceoptimization(int[] arr, int difference) {
        // 1. Identify the range to handle negative numbers
        int min = -10000, max = 10000;
        for (int num : arr) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }

        // 2. Create an array to act as our DP table
        // Offset is used so that the minimum value maps to index 0
        int offset = -min;
        int[] dp = new int[max - min + 1];
        int maxLen = 0;

        for (int num : arr) {
            int currentIdx = num + offset;
            int prevIdx = (num - difference) + offset;

            // 3. Check bounds and update
            if (prevIdx >= 0 && prevIdx < dp.length) {
                dp[currentIdx] = dp[prevIdx] + 1;
            } else {
                dp[currentIdx] = 1;
            }

            if (dp[currentIdx] > maxLen)
                maxLen = dp[currentIdx];
        }

        return maxLen;
    }
}
