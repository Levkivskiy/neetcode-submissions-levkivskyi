class Solution {
        List<List<Integer>> subsets = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        helper(0, nums, curr);
        return subsets;
    }

    public void helper(int i, int[] nums, List<Integer> curr) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        helper(i + 1, nums, curr);
        curr.remove(curr.size() - 1);
        helper(i + 1, nums, curr);
    }
}
