class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int countMax = 1;
        int maxElement = nums[0];
        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            if (count > countMax) {
                countMax = count;
                maxElement = n;
            }
            map.put(n, count);
        }

        return maxElement;
    }
}