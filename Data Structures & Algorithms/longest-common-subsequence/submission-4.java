class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() + 1;
        int[] dp = new int[n];

        for (int i = 0; i < text2.length(); i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n - 1; j++) {
                if (text2.charAt(i) == text1.charAt(j)) {
                    curr[j + 1] = dp[j] + 1;
                } else {
                    curr[j + 1] = Math.max(dp[j + 1], curr[j]);
                }
            }
            dp = curr;
        }

        return dp[n - 1];
    }
}
