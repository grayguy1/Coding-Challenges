class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> children = new ArrayList<>();
            tree.put(i, children);
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        int result = dfs(tree, hasApple, 0, visited);
        return result * 2;
    }
    public int dfs(HashMap<Integer, ArrayList<Integer>> tree, List<Boolean> hasApple, Integer currVert, HashSet<Integer> visited) {
        if (visited.contains(currVert)) {
            return 0;
        }
        visited.add(currVert);
        int result = 0;
        for (int child : tree.get(currVert)) {
            result += dfs(tree, hasApple, child, visited);
        }
        if (result == 0 && hasApple.get(currVert) == true && currVert != 0) {
            return 1;
        }
        else if (result != 0 && currVert != 0) {
            return result + 1;
        }
        return result;
    }
}