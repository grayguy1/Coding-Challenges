class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastIdx = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lastIdx.containsKey(s.charAt(i)) && lastIdx.get(s.charAt(i)) >= start) {
                max = Math.max(max, end - start);
                start = lastIdx.get(s.charAt(i)) + 1;
            }
            lastIdx.put(s.charAt(i), i);
            end++;
        }
        max = Math.max(max, end - start);
        return max;
    }
}