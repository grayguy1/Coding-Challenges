// 1000 / 5 = 200; 15min
// 200 / 4 = 50; 30min
// 50 / 3 = 17; 45min
// 17 / 2 = 9; 60min



class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie;
        return (int)Math.ceil(Math.log(buckets) / Math.log(states + 1));
    }
}