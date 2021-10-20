class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < boxTypes.length; i++) {
            pq.add(boxTypes[i]);
        }
        int total = 0;
        while (!pq.isEmpty()) {
            if (truckSize == 0) {
                break;
            }
            int[] curr = pq.poll();
            if (curr[0] > truckSize) {
                total += truckSize * curr[1];
                truckSize = 0;
            }
            else {
                total += curr[0] * curr[1];
                truckSize -= curr[0];
            }
        }
        return total;
    }
}