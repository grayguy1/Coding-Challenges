class CustomStack {

    ArrayList<Integer> stack;
    int limit;
    public CustomStack(int maxSize) {
        stack = new ArrayList<>();
        limit = maxSize;
    }
    
    public void push(int x) {
        if (stack.size() < limit) {
            stack.add(x);
        }
    }
    
    public int pop() {
        if (stack.size() > 0) {
            int res = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return res;
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        int i = 0;
        System.out.println(stack);
        while (k > 0 && i < stack.size()) {
            stack.set(i, stack.get(i) + val);
            i++;
            k--;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */