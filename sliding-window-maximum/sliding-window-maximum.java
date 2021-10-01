class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < k; i++) {
            if (!dq.isEmpty() && dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        int[] result = new int[n - k + 1];
        result[0] = nums[idx];
        for (int i = k; i < n; i++) {
            if (!dq.isEmpty() && dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            result[i - k + 1] = nums[dq.getFirst()];
        }
        return result;
    }
}