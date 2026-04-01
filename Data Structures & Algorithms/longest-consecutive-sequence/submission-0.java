class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }
        int max = 0;
        for (int n : set) {
            if(!set.contains(n - 1)) {
                int i = 0;
                int curr = 0;
                while (set.contains(n + i)) {
                    curr++;
                    i++;
                }
                max = Math.max(curr, max);
            }
        }

        return max;
    }
}
