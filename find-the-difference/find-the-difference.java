class Solution {
    public char findTheDifference(String s, String t) {
        int sSize = 0;
        for (int i = 0; i < s.length(); i++) {
            sSize += s.charAt(i);
        }
        int tSize = 0;
        for (int i = 0; i < t.length(); i++) {
            tSize += t.charAt(i);
        }
        return (char)(tSize - sSize);
    }
}