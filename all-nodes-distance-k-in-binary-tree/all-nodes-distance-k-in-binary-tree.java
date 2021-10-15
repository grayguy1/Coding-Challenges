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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        dfs(root, parents, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        List<Integer> result = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            System.out.println(k);
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (visited.contains(curr)) {
                    continue;
                }
                visited.add(curr);
                if (k == 0) {
                    result.add(curr.val);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (parents.containsKey(curr)) {
                    queue.add(parents.get(curr));
                }
            }
            k--;
        }
        return result;
    }
    public void dfs(TreeNode root, HashMap<TreeNode, TreeNode> parents, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (parent != null) {
            parents.put(root, parent);
        }
        dfs(root.left, parents, root);
        dfs(root.right, parents, root);
    }
}