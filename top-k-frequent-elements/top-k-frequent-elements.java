class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> keys = new ArrayList<>(count.keySet());
        Collections.sort(keys, (a, b) -> count.get(a) - count.get(b));
        Collections.reverse(keys);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (i > keys.size()) {
                break;
            }
            result[i] = keys.get(i);
        }
        return result;
    }
}