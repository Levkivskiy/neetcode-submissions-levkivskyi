class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public void helper(int i, List<Integer> subset) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }


        subset.add(nums[i]);
        helper(i + 1, subset);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        subset.remove(subset.size() - 1);
        helper(i + 1, subset);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        helper(0, new ArrayList<>());
        return res;
    }
}
