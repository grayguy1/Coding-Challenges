class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1;
        int k = n - 1;
        int end = nums1.length - 1;
        while (k >= 0 && j >= 0) {
            if (nums1[j] > nums2[k]) {
                nums1[end] = nums1[j];
                j--;
            }
            else {
                nums1[end] = nums2[k];
                k--;
            }
            end--;
        }
        while (k >= 0) {
            nums1[k] = nums2[k];
            k--;
        }
    }
}