/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long start = 0;
        long end = n;
        int first = 0;
        while (start <= end) {
            long m = (start + end) / 2;
            int mid = (int)m;
            if (isBadVersion(mid) == true) {
                first = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return first;
    }
}