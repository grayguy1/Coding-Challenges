class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int movMax = 0;
        for (int i = 0; i < nums.length; i++) {
            movMax = Math.max(movMax + nums[i], nums[i]);
            max = Math.max(max, movMax);
        }
        return max;
    }
}