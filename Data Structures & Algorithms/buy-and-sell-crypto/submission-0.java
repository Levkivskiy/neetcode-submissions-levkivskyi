class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int L = 0;
        for (int R = 0; R < prices.length; R++) {
            if(prices[L] > prices[R]) {
                L = R;
            }
            maxProfit = Math.max(maxProfit, prices[R] - prices[L]);
        }

        return maxProfit;
    }
}
