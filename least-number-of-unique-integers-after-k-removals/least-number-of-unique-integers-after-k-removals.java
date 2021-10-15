class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        for (int key : count.keySet()) {
            pq.add(key);
        }
        while (!pq.isEmpty() && k > 0) {
            int top = pq.poll();
            if (count.get(top) <= k) {
                k = k - count.get(top);
                count.remove(top);
            }
        }
        return count.size();
    }
}