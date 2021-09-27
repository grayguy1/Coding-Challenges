class Solution {
    public boolean canJump(int[] nums) {
        int step = nums[0];
        int i = 1;
        while (i < nums.length && step > 0) {
            step--;
            step = Math.max(step, nums[i]);
            i++;
        }
        if (i >= nums.length) {
            return true;
        }
        return false;
    }
}