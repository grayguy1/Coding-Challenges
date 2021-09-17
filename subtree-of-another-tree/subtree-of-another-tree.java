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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.val == t.val) {
                if (compare(curr, t) == true) {
                    return true;
                }
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return false;
    }
    public boolean compare(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        else if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return compare(s.left, t.left) && compare(s.right, t.right);
    }
}