class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int countZero = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                countZero++;
            }
            if (countZero > k) {
                if (nums[left] == 0) {
                    countZero--;
                }
                left++;
            }
            right++;
        }
        return right - left;
    }
}