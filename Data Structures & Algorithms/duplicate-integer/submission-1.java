class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();

        for(int n : nums) {
            set.add(n);
        }

        return set.size() != nums.length;
    }
}