class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int sum = 0;
        int L = 0;

        for(int R = 0; R < nums.length; R++) {
            sum += nums[R];
            while (sum >= target) {
                length = Math.min(length, R - L + 1);
                sum -= nums[L];
                L++;
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}