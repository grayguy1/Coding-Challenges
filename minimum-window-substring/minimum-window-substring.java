// "ADOBECODEBANC", "ABC"
// "ADOBEC" "DOBEC"
// "DOBECODEBA" "ODEBA"
// "ODEBANC" "BANC"
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int maxRight = Integer.MAX_VALUE;
        int maxLeft = 0;
        String maxStr = "";
        int[] tCount = new int[126];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }
        int[] sCount = new int[126];
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // increment one character
            sCount[s.charAt(right)]++;
            // decrement one character
            tCount[s.charAt(right)]--;
            while (isCountEmpty(tCount) == true) {
                if (right - left < maxRight - maxLeft) {
                    maxRight = right;
                    maxLeft = left;
                }
                tCount[s.charAt(left)]++;
                left++;
            }
            right++;
        }
        if (maxRight >= Integer.MAX_VALUE) {
            return "";
        }
        maxStr = s.substring(maxLeft, maxRight + 1);
        return maxStr;
    }
    // constant TC
    public boolean isCountEmpty(int[] count) {
        for (int i = 0; i < 126; i++) {
            if(count[i] > 0) {
                return false;
            }
        }
        return true;
    }
}