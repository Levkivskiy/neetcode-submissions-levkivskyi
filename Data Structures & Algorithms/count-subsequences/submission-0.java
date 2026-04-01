class Solution {
    int[][] dp;

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }
        this.dp = dp;
        return dfs(s, t, 0, 0);
    }

    public int dfs(String str, String target, int i, int j) {
        if (j == target.length()) {
            return 1;
        }
        if (i == str.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int sum = dfs(str, target, i + 1, j);
        if (str.charAt(i) == target.charAt(j)) {
            sum += dfs(str, target, i + 1, j + 1);
        }
        dp[i][j] = sum;

        return sum;
    }
}
