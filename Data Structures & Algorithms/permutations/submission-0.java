class Solution {
    public List<List<Integer>> helper(int i, int[] nums) {
        if(i == nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> curr = helper(i + 1, nums);
        List<List<Integer>> res = new ArrayList<>();

        for (List<Integer> arr : curr) {
            for(int j = 0; j <= arr.size(); j++)  {
                List<Integer> newArr = new ArrayList<>(arr);
                newArr.add(j, nums[i]);
                res.add(newArr);
            }
        }

        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        return helper(0, nums);
    }
}
