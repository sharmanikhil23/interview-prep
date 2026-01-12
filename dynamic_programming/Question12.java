package dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;

public class Question12 {
    public static int recursion(int[] days, int[] cost) {
        return recursion(days, cost, days.length - 1);
    }

    private static int recursion(int[] days, int[] cost, int index) {
        if (index < 0) {
            return 0;
        }

        int oneDayPass = cost[0] + recursion(days, cost, index - 1);
        int sevenDayPass = cost[1] + recursion(days, cost, findIndex(days, index, 7));
        int thirtyDaysPass = cost[2] + recursion(days, cost, findIndex(days, index, 30));

        return Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDaysPass));
    }

    private static int recursion2(int n, int[] days, int[] costs, int index) {
        if (index >= n) {
            return 0;
        }

        int oneDayPass = costs[0] + recursion2(n, days, costs, index + 1);

        int i;
        for (i = index; i < n && days[i] < days[index] + 7; i++)
            ;
        int sevenDayPass = costs[1] + recursion2(n, days, costs, i);

        for (i = index; i < n && days[i] < days[index] + 30; i++)
            ;

        int thirtyDaysPass = costs[2] + recursion2(n, days, costs, i);

        return Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDaysPass));
    }

    private static int findIndex(int[] days, int index, int pass) {
        int leftDays = days[index] - pass;
        while (index >= 0 && days[index] > leftDays) {
            index--;
        }
        return index;
    }

    public static int memorization(int[] days, int[] cost) {
        int[] data = new int[days.length];
        Arrays.fill(data, -1);
        return memorization(days, cost, days.length - 1, data);
    }

    private static int memorization(int[] days, int[] cost, int index, int[] result) {
        if (index < 0) {
            return 0;
        }

        if (result[index] != -1) {
            return result[index];
        }

        int oneDayPass = cost[0] + memorization(days, cost, index - 1, result);
        int sevenDayPass = cost[1] + memorization(days, cost, findIndex(days, index, 7), result);
        int thirtyDaysPass = cost[2] + memorization(days, cost, findIndex(days, index, 30), result);

        return result[index] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDaysPass));
    }

    // this is still slow as everytime we go back and see which index it will cover
    // or not
    public static int tabulation(int[] days, int[] cost) {
        int[] data = new int[days.length];
        data[0] = cost[0];

        for (int i = 0; i < data.length; i++) {
            int oneDayPass = cost[0] + data[i - 1];

            // checking how many days will be covered with this one
            int temp = findIndex(days, i, 7);
            int sevenDayPass = cost[1];
            if (temp != -1) {
                sevenDayPass += data[temp];
            }

            temp = findIndex(days, i, 30);
            int thirtyDaysPass = cost[2];
            if (temp != -1) {
                thirtyDaysPass += data[temp];
            }

            data[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDaysPass));
        }
        return data[data.length - 1];
    }

    // More faster way to do it
    public int tabulation2(int[] days, int[] costs) {
        // The last day on which we need to travel.
        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];
        Arrays.fill(dp, 0);

        int i = 0;
        for (int day = 1; day <= lastDay; day++) {
            // If we don't need to travel on this day, the cost won't change.
            if (day < days[i]) {
                dp[day] = dp[day - 1];
            } else {
                // Buy a pass on this day, and move on to the next travel day.
                i++;
                // Store the cost with the minimum of the three options.
                dp[day] = Math.min(dp[day - 1] + costs[0],
                        Math.min(dp[Math.max(0, day - 7)] + costs[1],
                                dp[Math.max(0, day - 30)] + costs[2]));
            }
        }

        return dp[lastDay];
    }

    static HashSet<Integer> isTravelNeeded = new HashSet<>();

    private static int memorization2(int[] dp, int[] days, int[] costs, int currDay) {
        // If we have iterated over travel days, return 0.
        if (currDay > days[days.length - 1]) {
            return 0;
        }

        // If we don't need to travel on this day, move on to next day.
        if (!isTravelNeeded.contains(currDay)) {
            return memorization2(dp, days, costs, currDay + 1);
        }

        // If already calculated, return from here with the stored answer.
        if (dp[currDay] != -1) {
            return dp[currDay];
        }

        int oneDay = costs[0] + memorization2(dp, days, costs, currDay + 1);
        int sevenDay = costs[1] + memorization2(dp, days, costs, currDay + 7);
        int thirtyDay = costs[2] + memorization2(dp, days, costs, currDay + 30);

        // Store the cost with the minimum of the three options.
        return dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }

    public static int memorization2(int[] days, int[] costs) {
        // The last day on which we need to travel.
        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];
        Arrays.fill(dp, -1);

        // Mark the days on which we need to travel.
        for (int day : days) {
            isTravelNeeded.add(day);
        }

        return memorization2(dp, days, costs, 1);
    }
}
