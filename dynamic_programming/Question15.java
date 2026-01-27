package dynamic_programming;

import java.util.Arrays;;

public class Question15 {

    public static int recursion(int[] obstacles) {
        return recursion(obstacles, 0, 2);
    }

    private static int recursion1(int[] obstacles, int index, int currentPosition) {
        if (index == obstacles.length) {
            return 0;
        }

        if (obstacles[index + 1] != currentPosition) {
            return recursion1(obstacles, index + 1, currentPosition);
        } else {
            int result = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                if (currentPosition != i && obstacles[index] != -1) {
                    result = Math.min(result, 1 + recursion1(obstacles, index, i));
                }
            }
            return result;
        }
    }

    private static int recursion(int[] obstacles, int index, int currentPosition) {
        if (index == obstacles.length) {
            return 0;
        }

        if (obstacles[index] == currentPosition) {
            return Integer.MAX_VALUE;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= 3; i++) {
            if (obstacles[index] != i) {
                if (currentPosition == i) {
                    result = Math.min(result, recursion(obstacles, index + 1, currentPosition));
                } else {
                    int jump = recursion(obstacles, index + 1, i);
                    if (jump != Integer.MAX_VALUE) {
                        result = Math.min(result, 1 + recursion(obstacles, index + 1, i));
                    }
                }
            }
        }

        return result;
    }

    public static int memorization(int[] obstacles) {
        int[][] result = new int[obstacles.length][4];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        return memorization(obstacles, 0, 2, result);
    }

    private static int memorizaation1(int[] obstacles, int index, int currentPosition, int[][] r) {
        if (index == obstacles.length) {
            return 0;
        }

        if (r[index][currentPosition] != -1) {
            return r[index][currentPosition];
        }

        if (obstacles[index + 1] != currentPosition) {
            return r[index][currentPosition] = memorizaation1(obstacles, index + 1, currentPosition, r);
        } else {
            int result = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                if (currentPosition != i && obstacles[index] != -1) {
                    result = Math.min(result, 1 + memorizaation1(obstacles, index, i, r));
                }
            }
            return r[index][currentPosition] = result;
        }
    }

    private static int memorization(int[] obstacles, int index, int currentPosition, int[][] r) {
        if (index == obstacles.length) {
            return 0;
        }

        if (obstacles[index] == currentPosition) {
            return Integer.MAX_VALUE;
        }

        if (r[index][currentPosition] != -1) {
            return r[index][currentPosition];
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= 3; i++) {
            if (obstacles[index] != i) {
                if (currentPosition == i) {
                    result = Math.min(result, memorization(obstacles, index + 1, currentPosition, r));
                } else {
                    int jump = memorization(obstacles, index + 1, i, r);
                    if (jump != Integer.MAX_VALUE) {
                        result = Math.min(result, 1 + jump);
                    }
                }
            }
        }

        return r[index][currentPosition] = result;
    }

    public static int tabulation1(int[] obstacles) {
        int n = obstacles.length - 1;
        int[][] dp = new int[n + 1][4];
        int INF = 1_000_000;

        for (int i = n - 1; i >= 0; i--) {
            // 1. First Pass: Move Forward (All lanes)
            for (int j = 1; j <= 3; j++) {
                if (obstacles[i] == j || obstacles[i + 1] == j) {
                    dp[i][j] = INF;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }

            // 2. Second Pass: Check if jumping sideways at index i is better
            for (int j = 1; j <= 3; j++) {
                if (obstacles[i] == j)
                    continue;
                for (int nextLane = 1; nextLane <= 3; nextLane++) {
                    if (j == nextLane || obstacles[i] == nextLane)
                        continue;

                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][nextLane]);
                }
            }
        }

        return Math.min(dp[0][2], Math.min(1 + dp[0][1], 1 + dp[0][3]));
    }

    public static int spaceOptimized(int[] obstacles) {
        int n = obstacles.length - 1;
        int INF = 1_000_000;

        // This represents dp[i + 1]
        int[] next = new int[4];

        // Base Case: At index n, cost is 0
        // (Java initializes arrays to 0, so next[1]=next[2]=next[3]=0 is already set)

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[4];

            // Pass 1: Move forward from next to curr
            for (int lane = 1; lane <= 3; lane++) {
                if (obstacles[i] == lane || obstacles[i + 1] == lane) {
                    curr[lane] = INF;
                } else {
                    curr[lane] = next[lane];
                }
            }

            // Pass 2: Sideway jumps within curr
            for (int lane = 1; lane <= 3; lane++) {
                if (obstacles[i] == lane)
                    continue;

                for (int otherLane = 1; otherLane <= 3; otherLane++) {
                    if (lane == otherLane || obstacles[i] == otherLane)
                        continue;

                    curr[lane] = Math.min(curr[lane], 1 + curr[otherLane]);
                }
            }

            // Update: current row becomes the 'next' row for the next iteration
            next = curr;
        }

        // Starting at index 0, Lane 2 (allowing for a jump if Lane 2 is blocked)
        return Math.min(next[2], Math.min(1 + next[1], 1 + next[3]));
    }
}
