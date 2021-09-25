class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int s1 = r(nums, 0, nums.length - 2);
        int s2 = r(nums, 1, nums.length - 1);
        return Math.max(s1, s2);
    }
    public int r(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 1];
        dp[end + 1] = 0;
        dp[end] = nums[end];
        for (int i = end - 1; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return Math.max(dp[start], dp[start + 1]);
    }
}