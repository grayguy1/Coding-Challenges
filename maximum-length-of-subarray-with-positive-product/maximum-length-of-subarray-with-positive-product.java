class Solution {
    public int getMaxLen(int[] nums) {
        int pos = 0;
        int neg = 0;
        int max = 0;
        int negIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos++;
                if (neg > 0) {
                    neg++;
                }
            }
            else if (nums[i] < 0) {
                int x = pos;
                if (neg == 0) {
                    pos = 0;
                }
                else {
                    pos = neg + 1;
                }
                neg = x + 1;
            }
            else {
                pos = 0;
                neg = 0;
            }
            max = Math.max(max, pos);
        }
        return max;
    }
}