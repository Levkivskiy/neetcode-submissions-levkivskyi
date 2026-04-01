class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int currIndex = 0;
        int headIndex = 0;

        for(int i = 0; i + 1 < nums.length; i++) {
            if(nums[currIndex] != nums[i + 1]){
                currIndex++;
            }
            nums[currIndex] = nums[i + 1];
        }

        return currIndex + 1;
    }
}