class Solution {
    public int maxArea(int[] heights) {
        int maxSum = 0;

        int L = 0, R = heights.length - 1;
        while (L < R) {
            int area = Math.min(heights[L], heights[R]) * (R - L);
            maxSum = Math.max(area, maxSum);
            if(heights[L] > heights[R]) {
                R--;
            } else {
                L++;
            }
        }

        return maxSum;
    }
}
