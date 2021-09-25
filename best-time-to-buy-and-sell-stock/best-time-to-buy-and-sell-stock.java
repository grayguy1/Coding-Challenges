class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int max = 0;
        while (sell < prices.length) {
            if (prices[sell] < prices[buy]) {
                buy = sell;
            }
            max = Math.max(max, prices[sell] - prices[buy]);
            sell++;
        }
        return max;
    }
}