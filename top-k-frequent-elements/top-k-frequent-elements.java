class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> numSet = new ArrayList<>(countMap.keySet());
        Collections.sort(numSet, (a, b) -> countMap.get(b) - countMap.get(a));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = numSet.get(i);
        }
        return result;
    }
}