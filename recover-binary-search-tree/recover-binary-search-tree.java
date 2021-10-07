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
    TreeNode prevNode = null;
    TreeNode r1 = null;
    TreeNode r2 = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = r1.val;
        r1.val = r2.val;
        r2.val = temp;
    }
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prevNode != null && root.val <= prevNode.val) {
            r1 = root;
            if (r2 == null) {
                r2 = prevNode;
            }
        }
        prevNode = root;
        inOrder(root.right);
    }
}