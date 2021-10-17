// [1,3,5,6] [2,3,4,5]
// [1,2,3,3,4,5,5,6], mid = 3,4
// left1 = 0, right1 = 3, mid = 1
// left2 = 0, right2 = 3, mid = 1

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        int half = (l1 + l2) / 2;
        int left = 0;
        int right = nums1.length - 1;
        
        while (true) {
            int mid1 = Math.floorDiv(left + right, 2);
            int mid2 = half - mid1 - 2;
            
            int left1 = Integer.MIN_VALUE;
            int right1 = Integer.MAX_VALUE;
            int left2 = Integer.MIN_VALUE;
            int right2 = Integer.MAX_VALUE;
            if (mid1 >= 0) {
                left1 = nums1[mid1];
            }
            if (mid2 >= 0) {
                left2 = nums2[mid2];
            }
            if (mid1 + 1 < l1) {
                right1 = nums1[mid1 + 1];
            }
            if (mid2 + 1 < l2) {
                right2 = nums2[mid2 + 1];
            }
            
            if (left1 <= right2 && left2 <= right1) {
                double median = 0;
                if ((l1 + l2) % 2 == 0) {
                    median = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                else {
                    median = Math.min(right1, right2);
                }
                return median;
            }
            else if (left1 > right2) {
                right = mid1 - 1;
            }
            else {
                left = mid1 + 1;
            }
        }
    }
}