class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int currIndex = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[currIndex] != nums[i]){
                currIndex++;
            }
            nums[currIndex] = nums[i];
        }

        return currIndex + 1;
    }
}