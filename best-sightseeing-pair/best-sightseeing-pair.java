// [3,7,2,3]
//  3,8,4,6
//  3,6,0,0
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                max = Math.max(max, pq.peek() + values[i] - i);
            }
            pq.add(values[i] + i);
        }
        return max;
    }
}