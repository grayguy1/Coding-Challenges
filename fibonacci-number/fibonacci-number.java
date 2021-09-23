class Solution {
    public int fib(int n) {
        int first = 0;
        int second = 1;
        if (n == 0) {
            return first;
        }
        while (n > 1) {
            int temp = first + second;
            first = second;
            second = temp;
            n--;
        }
        return second;
    }
}