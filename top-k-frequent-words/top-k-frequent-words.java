class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
            new Comparator<String> () {
                public int compare(String word1, String word2) {
                    if (map.get(word1) == map.get(word2)) {
                        return word2.compareTo(word1);
                    }
                    else {
                        return map.get(word1) - map.get(word2);
                    }
                }
            });
        for (String s : map.keySet()) {
            pq.add(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll());
        }
        return result;
    }
}