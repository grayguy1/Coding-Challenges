// [2,3,1,1,4]
class Solution {
    public int jump(int[] nums) {
        int jumpAvailable = 0;
        int maxJump = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            jumpAvailable = Math.max(jumpAvailable, nums[i] + i);
            if (i == end) {
                maxJump++;
                end = jumpAvailable;
            }
        }
        return maxJump;
    }
}