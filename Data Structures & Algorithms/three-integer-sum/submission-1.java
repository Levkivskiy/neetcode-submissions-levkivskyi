class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (nums[L] + nums[R] + nums[i] == 0) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[L]);
                    arr.add(nums[R]);
                    arr.add(nums[i]);
                    res.add(arr);
                    R--;
                    L++;
                } else if (nums[L] + nums[R] + nums[i] > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        
        return res.stream().toList();
    }
}