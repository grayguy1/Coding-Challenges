class Solution {
    public int[] sortedSquares(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int sIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < smallest) {
                smallest = Math.abs(nums[i]);
                sIndex = i;
            }
        }
        int[] squares = new int[nums.length];
        int left = sIndex -1;
        int right = sIndex;
        if (sIndex == 0) {
            left = sIndex;
            right = sIndex + 1;
        }
        int j = 0;
        while (left >= 0 && right < nums.length) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                squares[j] = nums[left] * nums[left];
                left--;
            }
            else {
                squares[j] = nums[right] * nums[right];
                right++;
            }
            j++;
        }
        while (left >= 0) {
            squares[j] = nums[left] * nums[left];
            left--;
            j++;
        }
        while (right < nums.length) {
            squares[j] = nums[right] * nums[right];
            right++;
            j++;
        }
        return squares;
    }
}