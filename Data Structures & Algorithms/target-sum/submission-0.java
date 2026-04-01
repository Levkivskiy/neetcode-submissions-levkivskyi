class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> curr = new HashMap<>();
            for (var entry : dp.entrySet()) {
                int number = entry.getKey();
                int count = entry.getValue();
                int addKey = number - nums[i];
                int removeKey = number + nums[i];

                curr.put(addKey, curr.getOrDefault(addKey, 0) + count);
                curr.put(removeKey, curr.getOrDefault(removeKey, 0) + count);
            }
            dp = curr;
        }

        return dp.getOrDefault(target, 0);
    }
}