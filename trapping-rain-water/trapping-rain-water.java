// [0,1,0,2,1,0,1,3,2,1,2,1]
// 1 + 1 + 
class Solution {
    public int trap(int[] height) {
        int result = 0;
        int peak = 0;
        int peakIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (peak <= height[i]) {
                peak = height[i];
                peakIndex = i;
            }
        }
        int leftMax = 0;
        for (int i = 0; i < peakIndex; i++) {
            leftMax = Math.max(leftMax, height[i]);
            result += Math.min(peak, leftMax) - height[i];
        }
        int rightMax = 0;
        for (int i = height.length - 1; i >= peakIndex; i--) {
            rightMax = Math.max(rightMax, height[i]);
            result += Math.min(peak, rightMax) - height[i];
        }
        return result;
    }
}