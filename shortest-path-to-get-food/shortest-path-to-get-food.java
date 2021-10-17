class Solution {
    public int getFood(char[][] grid) {
        int[] loc = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '*') {
                    loc[0] = i;
                    loc[1] = j;
                    break;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(loc);
        HashSet<String> visited = new HashSet<>();
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] >= 0 && curr[0] < grid.length && curr[1] >= 0 && curr[1] < grid[0].length) {
                    String key = curr[0] + " " + curr[1];
                    if (!visited.contains(key) && grid[curr[0]][curr[1]] != 'X') {
                        visited.add(key);
                        if (grid[curr[0]][curr[1]] == '#') {
                            return dist;
                        }
                        queue.add(new int[]{curr[0], curr[1] - 1});
                        queue.add(new int[]{curr[0], curr[1] + 1});
                        queue.add(new int[]{curr[0] - 1, curr[1]});
                        queue.add(new int[]{curr[0] + 1, curr[1]});
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}