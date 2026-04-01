class Solution {
        public int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;

        while (L <= R) {
            int M = L + (R - L) / 2;
            if(nums[M] == target) return M;
            if(nums[L] <= nums[M]) {
                if(nums[L] <= target && target <= nums[M]) {
                    R = M - 1;
                } else {
                    L = M + 1;
                }
            } else {
                if(nums[M] <= target && target <= nums[R]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
        }

        return -1;
    }
}
