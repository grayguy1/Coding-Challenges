class FirstUnique {
    HashMap<Integer, Boolean> map = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    public FirstUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.peek()) == false) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }
    
    public void add(int value) {
        if (!map.containsKey(value)) {
            map.put(value, true);
            queue.add(value);
        }
        else {
            map.put(value, false);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */