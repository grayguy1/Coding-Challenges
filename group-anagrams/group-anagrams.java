// ["eat","tea","tan","ate","nat","bat"]
// []
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!result.containsKey(key)) {
                List<String> l = new ArrayList<>();
                result.put(key, l);
            }
            result.get(key).add(str);
        }
        return new ArrayList(result.values());
    }
}