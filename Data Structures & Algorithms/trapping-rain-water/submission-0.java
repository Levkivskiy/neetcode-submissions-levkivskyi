class Solution {
    public int trap(int[] height) {
        int[] canBeFill = new int[height.length];
        int L = 0, R = height.length - 1;
        int maxFill = 0;

        while (L < R) {
            canBeFill[L] = maxFill;
            canBeFill[R] = maxFill;
            maxFill = Math.max(Math.min(height[R], height[L]), maxFill);
            if (height[L] > height[R])
                R--;
            else
                L++;
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.max((canBeFill[i] - height[i]), 0);
        }

        return sum;
    }
}
