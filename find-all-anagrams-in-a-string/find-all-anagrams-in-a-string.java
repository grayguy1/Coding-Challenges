class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int start = 0;
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < pLen; i++) {
            pArr[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length() + 1; i++) {
            if (i - start == pLen) {
                if (compare(sArr, pArr) == true) {
                    result.add(start);
                }
                sArr[s.charAt(start) - 'a']--;
                start++;
            }
            if (i < s.length()) {
                sArr[s.charAt(i) - 'a']++;
            }
        }
        return result;
    }
    public boolean compare(int[] sArr, int[] pArr) {
        for (int i = 0; i < 26; i++) {
            if (sArr[i] != pArr[i]) {
                return false;
            }
        }
        return true;
    }
}