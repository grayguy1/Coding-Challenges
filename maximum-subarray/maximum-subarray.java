class Solution {
    public int maxSubArray(int[] nums) {
        int subSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            subSum = Math.max(subSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, subSum);
        }
        return maxSum;
    }
}