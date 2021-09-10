class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
            if (set.size() > 3) {
                set.remove(Collections.min(set));
            }
        }
        if (set.size() < 3) {
            return Collections.max(set);
        }
        return Collections.min(set);
    }
}