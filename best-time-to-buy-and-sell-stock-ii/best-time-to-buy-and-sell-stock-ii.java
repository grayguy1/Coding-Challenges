class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int profit = 0;
        while (sell < prices.length) {
            if (prices[sell] < prices[buy]) {
                buy = sell;
            }
            else if (prices[sell] > prices[buy]) {
                profit += prices[sell] - prices[buy];
                buy = sell;
            }
            sell++;
        }
        return profit;
    }
}