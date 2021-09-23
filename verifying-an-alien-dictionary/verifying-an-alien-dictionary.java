class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            int k = 0;
            while (j < words[i].length() && k < words[i + 1].length()) {
                int first = orderMap.get(words[i].charAt(j));
                int second = orderMap.get(words[i + 1].charAt(k));
                if (first < second) {
                    break;
                }
                if (first > second) {
                    return false;
                }
                j++;
                k++;
            }
            if (k == words[i + 1].length() && words[i + 1].length() != words[i].length()) {
                return false;
            }
        }
        return true;
    }
}