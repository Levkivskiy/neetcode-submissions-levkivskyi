class Solution {
    int[] nums;
    int sum;
    int[][] cache;

    public boolean db(int i, int combined) {
        if (combined * 2 == sum) {
            return true;
        }
        if (i >= nums.length || combined * 2 > sum) {
            return false;
        }
        if(cache[i][combined] != 0) {
            return cache[i][combined] > 0;
        }
        
        boolean notInclude = db(i + 1, combined);
        boolean include = db(i + 1, combined + nums[i]);

        cache[i][combined] = include || notInclude ? 1 : -1;

        return cache[i][combined] > 0;
    }

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        this.sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        cache = new int[nums.length][sum / 2];

        for (int i = 0; i < nums.length; i++) {
            int[] arr = new int[sum / 2];
            Arrays.fill(arr, 0);
            cache[i] = arr;
        }

        return db(0, 0);
    }
}
