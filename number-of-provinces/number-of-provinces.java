class Solution {
    /*
    * [[1,1,0],
    *  [1,1,0],
    *  [0,0,1]]
    */
    public int findCircleNum(int[][] isConnected) {
        HashSet<Integer> visited = new HashSet<>();
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }
    public void dfs(int[][] isConnected, HashSet<Integer> visited, int curr) {
        if (visited.contains(curr)) {
            return;
        }
        visited.add(curr);
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[curr][i] != 0) {
                dfs(isConnected, visited, i);
            }
        }
    }
}