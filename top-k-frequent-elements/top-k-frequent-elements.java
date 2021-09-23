class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> numSet = new ArrayList<>(countMap.keySet());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> countMap.get(a) - countMap.get(b)
        );
        for (int i = 0; i < numSet.size(); i++) {
            pq.add(numSet.get(i));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}