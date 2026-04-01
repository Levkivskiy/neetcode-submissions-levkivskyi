class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> subsets = new ArrayList<>();
    int currSum = 0;

    public void helper(int i, int[] nums, int target) {
        if (currSum == target) {
            res.add(new ArrayList<>(subsets));
            return;
        } else if (i >= nums.length || currSum > target) {
            return;
        }

        subsets.add(nums[i]);
        currSum += nums[i];
        helper(i, nums, target);
        subsets.removeLast();
        currSum -= nums[i];
        helper(i + 1, nums, target);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(0, nums, target);
        return res;
    }
}
