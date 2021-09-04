class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else if (curr == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else if (curr == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else {
                stack.push(curr);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}