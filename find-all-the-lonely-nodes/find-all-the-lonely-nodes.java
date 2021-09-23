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
    List<Integer> result = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        dfs(root);
        return result;
    }
    public void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right != null) {
            result.add(curr.right.val);
        }
        else if (curr.left != null && curr.right == null) {
            result.add(curr.left.val);
        }
        dfs(curr.left);
        dfs(curr.right);
    }
}