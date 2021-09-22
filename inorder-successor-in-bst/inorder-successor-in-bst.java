/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        TreeNode result = null;
        for (int i = 0; i < list.size(); i++) {
            if (p == list.get(i)) {
                if (i < list.size() - 1) {
                    result = list.get(i + 1);
                }
                break;
            }
        }
        return result;
    }
    public void inorder(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}