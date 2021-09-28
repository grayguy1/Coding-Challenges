class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int limit = v1.length;
        if (v2.length < limit) {
            limit = v2.length;
        }
        int i = 0;
        int j = 0;
        while (i < v1.length && j < v2.length) {
            if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[j])) {
                return -1;
            }
            else if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[j])) {
                return 1;
            }
            i++;
            j++;
        }
        while (i < v1.length) {
            if (Integer.valueOf(v1[i]) > 0) {
                return 1;
            }
            i++;
        }
        while (j < v2.length) {
            if (Integer.valueOf(v2[j]) > 0) {
                return -1;
            }
            j++;
        }
        return 0;
    }
}