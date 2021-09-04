class Solution {
    public boolean isPalindrome(String s) {
        // ignore cases
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char lchar = s.charAt(left);
            char rchar = s.charAt(right);
            if (!checkAlphanumeric(lchar)) {
                left++;
            }
            else if (!checkAlphanumeric(rchar)) {
                right--;
            }
            else {
                if (lchar != rchar) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
    public boolean checkAlphanumeric(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}