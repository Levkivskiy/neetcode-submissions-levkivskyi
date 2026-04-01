class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int currIndex = 0;
        int headIndex = 0;

        for(int i = 0; i + 1 < nums.length; i++) {
            if(nums[currIndex] == nums[i + 1]) {
                headIndex++;
            } else {
                currIndex++;
                headIndex++;
            }
            nums[currIndex] = nums[headIndex];
        }

        return currIndex + 1;
    }
}