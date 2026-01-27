package dynamic_programming;

import java.util.Arrays;

public class Question18 {
    public static int recursion(int[][] cuboids) {
        for (int[] cube : cuboids) {
            Arrays.sort(cube);
        }

        // if two instaance of lenght, width become equal use height to sort properly
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        return recursion(cuboids, cuboids.length - 1, cuboids.length);
    }

    public static int recursion(int[][] cuboids, int index, int prev) {
        if (index < 0) {
            return 0;
        }

        int takeIt = 0;

        if (prev == cuboids.length || (cuboids[index][0] <= cuboids[prev][0] && cuboids[index][1] <= cuboids[prev][1]
                && cuboids[index][2] <= cuboids[prev][2])) {
            takeIt = cuboids[index][2] + recursion(cuboids, index - 1, index);
        }

        int notTakeIt = recursion(cuboids, index - 1, prev);

        return Math.max(takeIt, notTakeIt);
    }

    public static int memorization(int[][] cuboids) {
        for (int[] cube : cuboids) {
            Arrays.sort(cube);
        }

        // if two instaance of lenght, width become equal use height to sort properly
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        int[][] result = new int[cuboids.length][cuboids.length + 1];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        return memorization(cuboids, cuboids.length - 1, cuboids.length, result);
    }

    public static int memorization(int[][] cuboids, int index, int prev, int[][] result) {
        if (index < 0) {
            return 0;
        }

        if (result[index][prev] != -1) {
            return result[index][prev];
        }

        int takeIt = 0;

        if (prev == cuboids.length || (cuboids[index][0] <= cuboids[prev][0] && cuboids[index][1] <= cuboids[prev][1]
                && cuboids[index][2] <= cuboids[prev][2])) {
            takeIt = cuboids[index][2] + memorization(cuboids, index - 1, index, result);
        }

        int notTakeIt = memorization(cuboids, index - 1, prev, result);

        return result[index][prev] = Math.max(takeIt, notTakeIt);
    }

    public static int tabulation1(int[][] cuboids) {
        for (int[] c : cuboids)
            Arrays.sort(c);

        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            if (a[1] != b[1])
                return a[1] - b[1];
            return a[2] - b[2];
        });

        int n = cuboids.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {

                int notTake = dp[curr + 1][prev + 1];
                int take = 0;

                if (prev == -1 ||
                        (cuboids[curr][0] >= cuboids[prev][0] &&
                                cuboids[curr][1] >= cuboids[prev][1] &&
                                cuboids[curr][2] >= cuboids[prev][2])) {

                    take = cuboids[curr][2] + dp[curr + 1][curr + 1];
                }

                dp[curr][prev + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }

}
