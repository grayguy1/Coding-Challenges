class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (i < s.length()) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        Character result = ' ';
        for (Character c : map.keySet()) {
            if (map.get(c) != 0) {
                result = c;
                break;
            }
        }
        return result;
    }
}