/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    double max = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }
    public double[] dfs(TreeNode root) {
        double[] result = new double[2];
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            result[0] = root.val;
            result[1] = 1;
            return result;
        }
        double[] left = dfs(root.left);
        double[] right = dfs(root.right);
        double leftAvg = 0;
        if (left[1] != 0) {
            leftAvg = left[0] / left[1];
        }
        double rightAvg = 0;
        if (right[1] != 0) {
            rightAvg = right[0] / right[1];
        }
        result[0] = left[0] + right[0] + root.val;
        result[1] = left[1] + right[1] + 1;
        double currAvg = result[0] / result[1];
        max = Math.max(max, Math.max(currAvg, Math.max(leftAvg, rightAvg)));
        return result;
    }
}