class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor != image[sr][sc]) {
            dfs(image, sr, sc, newColor, image[sr][sc]);
        }
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        System.out.println(sr);
        if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) {
            return;
        }
        if (image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, newColor, oldColor);
        dfs(image, sr - 1, sc, newColor, oldColor);
        dfs(image, sr, sc + 1, newColor, oldColor);
        dfs(image, sr, sc - 1, newColor, oldColor);
    }
}