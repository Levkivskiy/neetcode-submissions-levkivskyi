class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = {0, 0, 0};

        for (int c : nums) {
            bucket[c]++;
        }

        int i = 0;
        for (int coloursI = 0; coloursI < bucket.length; coloursI++) {
                for (int sumI = 0; sumI < bucket[coloursI]; sumI++) {
                    nums[i] = coloursI;
                    i++;
                }
        }
    }
}