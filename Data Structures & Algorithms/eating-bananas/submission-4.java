class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = Arrays.stream(piles).max().orElse(0);

        int minKey = Integer.MAX_VALUE;
        int L = 1, R = maxK;
        while (L <= R) {
            int M = L + (R - L) / 2;
            int minToEat = hourToEat(piles, M, h);

            if (minToEat == Integer.MAX_VALUE) {
                L = M + 1;
            } else {
                R = M - 1;
                minKey = M;
            }
        }

        return minKey;
    }

    public int hourToEat(int[] piles, int k, int h) {
        int hours = 0;
        for (int banana : piles) {
            hours += (banana + k - 1) / k;
            if (hours > h) return Integer.MAX_VALUE;
        }

        return hours;
    }
}
