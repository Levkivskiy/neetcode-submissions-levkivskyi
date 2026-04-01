class Solution {
        public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dpWithFirst = new int[nums.length];
        int[] dpWithoutFirst = new int[nums.length];
        dpWithFirst[0] = nums[0];
        dpWithFirst[1] = Math.max(nums[0], nums[1]);

        dpWithoutFirst[0] = 0;
        dpWithoutFirst[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dpWithFirst[i] = Math.max(dpWithFirst[i - 1], dpWithFirst[i - 2] + nums[i]);
            dpWithoutFirst[i] = Math.max(dpWithoutFirst[i - 1], dpWithoutFirst[i - 2] + nums[i]);
        }

        return Math.max(dpWithoutFirst[nums.length - 1], dpWithFirst[nums.length - 2]);
    }
}
