class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = stack.peek();
            if (curr[1] >= intervals[i][0]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
                stack.pop();
                stack.push(curr);
            }
            else {
                stack.push(intervals[i]);
            }
        }
        int[][] merged = new int[stack.size()][2];
        int i = 0;
        while (!stack.isEmpty()) {
            merged[i] = stack.pop();
            i++;
        }
        return merged;
    }
}