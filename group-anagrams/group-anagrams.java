// ["eat","tea","tan","ate","nat","bat"]
// []
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] parents = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (checkAnagram(strs[i], strs[j])) {
                    union(parents, i, j);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            int group = find(parents, parents[i]);
            if (!map.containsKey(group)) {
                List<String> lst = new ArrayList<>();
                map.put(group, lst);
            }
            map.get(group).add(strs[i]);
        }
        for (int i : map.keySet()) {
            result.add(map.get(i));
        }
        return result;
    }
    public void union(int[] parents, int i, int j) {
        int a = find(parents, i);
        int b = find(parents, j);
        if (a == b) {
            return;
        }
        parents[j] = a;
    }
    public int find(int[] parents, int i) {
        if (parents[i] == i) {
            return i;
        }
        return parents[i] = find(parents, parents[i]);
    }
    public boolean checkAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < a.length(); i++) {
            map[a.charAt(i) - 'a']++;
            map[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}