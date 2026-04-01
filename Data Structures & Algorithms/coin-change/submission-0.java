class Solution {
        public int coinChange(int[] coins, int amount) {
        int n = amount + 1;
        int[] dp = new int[n];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int c : coins) {
            int[] curr = new int[n];
            Arrays.fill(curr, amount + 1);
            curr[0] = 0;
            for (int weight = 1; weight <= amount; weight++) {
                int skipCurrent = dp[weight];
                int includeCoin = amount + 1;

                if (weight - c >= 0) {
                    includeCoin = 1 + curr[weight - c];
                }
                curr[weight] = Math.min(includeCoin, skipCurrent);
            }
            dp = curr;
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
