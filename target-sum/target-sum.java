// [1,1,1,1,1]
//    0  1  2  3  4
// 0  
// 1  
// 2  
// 3  
// 4  
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int col = (2 * total) + 1;
        int[][] mat = new int[nums.length][col];
        mat[0][total + nums[0]] = 1;
        mat[0][total - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= 2 * total; j++) {
                if (mat[i - 1][j] > 0) {
                    mat[i][j + nums[i]] += mat[i - 1][j];
                    mat[i][j - nums[i]] += mat[i - 1][j];
                }
            }
        }
        if (Math.abs(target) > total) {
            return 0;
        }
        return mat[mat.length - 1][target + total];
    }
}