class Solution {
    public int minSteps(String s, String t) {
        int[] sCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (sCount[t.charAt(i) - 'a'] > 0) {
                sCount[t.charAt(i) - 'a']--;
            }
            else {
                count++;
            }
        }
        return count;
    }
}