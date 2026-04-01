class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(0, nums, memo);
    }

    public int dfs(int i, int[] nums, int[] memo) {
        if (i >= nums.length - 1) return 0;
        if (memo[i] != -1) return memo[i];

        int min = 99999;
        for (int jump = i + 1; jump <= i + nums[i]; jump++) {
            min = Math.min(dfs(jump, nums, memo), min);
        }
        memo[i] = min + 1;
        return memo[i];
    }
}
