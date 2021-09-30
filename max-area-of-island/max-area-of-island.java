class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    String key = Integer.toString(i) + " " + Integer.toString(j);
                    if (!visited.contains(key)) {
                        maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
                    }
                }
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int i, int j, HashSet<String> visited) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        String key = Integer.valueOf(i) + " " + Integer.valueOf(j);
        if (visited.contains(key)) {
            return 0;
        }
        visited.add(key);
        int area = 1;
        area += dfs(grid, i + 1, j, visited);
        area += dfs(grid, i - 1, j, visited);
        area += dfs(grid, i, j + 1, visited);
        area += dfs(grid, i, j - 1, visited);
        return area;
        
    }
}