class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]]++;
        }
        int prev = -1;
        int take = 0;
        int notTake = 0;
        for (int i = 0; i < dp.length; i++) {
            int currSum = i * dp[i];
            int max = Math.max(take, notTake);
            if (dp[i] > 0) {
                if (i - 1 == prev) {
                    take = currSum + notTake;
                    notTake = max;
                }
                else {
                    take = currSum + max;
                    notTake = max;
                }
                prev = i;
            }
        }
        return Math.max(take, notTake);
    }
}