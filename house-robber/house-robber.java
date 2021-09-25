class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[nums.length] = 0;
        dp[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }
}