class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (checkPalindrome(s, i, j)) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        str = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return str;
    }
    public boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}