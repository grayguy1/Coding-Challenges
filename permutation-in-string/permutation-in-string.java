class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }
        int start = 0;
        for (int i = 0; i < s2.length() + 1; i++) {
            if (i - start == s1.length()) {
                if (compare(count1, count2) == true) {
                    return true;
                }
                count2[s2.charAt(start) - 'a']--;
                start++;
            }
            if (i < s2.length()) {
                count2[s2.charAt(i) - 'a']++;
            }
        }
        return false;
    }
    public boolean compare(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}