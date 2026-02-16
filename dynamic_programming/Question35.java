package dynamic_programming;

public class Question35 {
    public boolean isMatch(String s, String p) {
        return spaceOptimization(s, p);
    }

    public boolean spaceOptimization(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[] curr = new boolean[m + 1];
        boolean[] prev = new boolean[m + 1];

        prev[m] = true;

        for (int j = m - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') {
                prev[j] = prev[j + 1];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                char sc = s.charAt(i);
                char pc = p.charAt(j);
                boolean match = false;

                if (pc == '*') {
                    match = curr[j + 1] || prev[j];
                } else if (pc == '?' || pc == sc) {
                    match = prev[j + 1];
                }

                curr[j] = match;
            }

            for (int k = 0; k <= m; k++) {
                prev[k] = curr[k];
            }
        }

        return prev[0];

    }

    public boolean tabulation(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[n][m] = true;

        // for s at n
        for (int j = m - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') {
                dp[n][j] = dp[n][j + 1];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                char sc = s.charAt(i);
                char pc = p.charAt(j);
                boolean match = false;

                if (pc == '*') {
                    match = dp[i][j + 1] || dp[i + 1][j];
                } else if (pc == '?' || pc == sc) {
                    match = dp[i + 1][j + 1];
                }

                dp[i][j] = match;
            }
        }

        return dp[0][0];
    }

    public boolean memorization(String s, String p) {
        Boolean[][] result = new Boolean[s.length() + 1][p.length() + 1];
        return memorization(s, p, 0, 0, result);
    }

    private boolean memorization(String s, String p, int sx, int px, Boolean[][] memo) {

        if (memo[sx][px] != null) {
            return memo[sx][px];
        }

        if (px == p.length()) {
            return sx == s.length();
        }

        if (sx == s.length()) {
            // Only a '*' can match an empty remaining string
            // Check if current char is '*' and recurse to see if the rest of the pattern is
            // also empty/*
            return p.charAt(px) == '*' && memorization(s, p, sx, px + 1, memo);
        }

        char sc = s.charAt(sx);
        char pc = p.charAt(px);

        boolean match = false;

        if (pc == '*') {
            match = memorization(s, p, sx, px + 1, memo) || memorization(s, p, sx + 1, px, memo);
        } else if (pc == '?' || pc == sc) {
            match = memorization(s, p, sx + 1, px + 1, memo);
        }

        return memo[sx][px] = match;
    }

    private boolean recursion(String s, String p, int sx, int px) {

        if (px == p.length()) {
            return sx == s.length();
        }

        if (sx == s.length()) {
            // Only a '*' can match an empty remaining string
            // Check if current char is '*' and recurse to see if the rest of the pattern is
            // also empty/*
            return p.charAt(px) == '*' && recursion(s, p, sx, px + 1);
        }

        char sc = s.charAt(sx);
        char pc = p.charAt(px);

        if (pc == '*') {
            return recursion(s, p, sx, px + 1) || recursion(s, p, sx + 1, px);
        }

        if (pc == '?' || pc == sc) {
            return recursion(s, p, sx + 1, px + 1);
        }

        return false;
    }
}
