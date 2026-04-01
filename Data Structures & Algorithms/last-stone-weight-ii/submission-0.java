class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;

        int[][] dp = new int[stones.length + 1][target + 1];

        for (int i = 1; i <= stones.length; i++) {
            for (int t = 1; t <= target; t++) {
                if (t >= stones[i - 1]) {
                    dp[i][t] = Math.max(dp[i - 1][t], dp[i - 1][t - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][t] = dp[i - 1][t];
                }
            }
        }

        return sum - 2 * dp[stones.length][target];
    }
}