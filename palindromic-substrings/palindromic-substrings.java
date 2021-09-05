class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += checkPalindrome(s, i, i);
            count += checkPalindrome(s, i, i + 1);
        }
        return count;
    }
    public int checkPalindrome(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }
        return count;
    }
}