// ["eat","tea","tan","ate","nat","bat"]
// []
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int j = 0; j < str.length(); j++) {
                count[str.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append(count[j]);
                sb.append(" ");
            }
            String key = sb.toString();
            if (!result.containsKey(key)) {
                List<String> l = new ArrayList<>();
                result.put(key, l);
            }
            result.get(key).add(str);
        }
        return new ArrayList(result.values());
    }
}