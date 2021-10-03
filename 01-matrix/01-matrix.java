class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], 100000);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                }
                else {
                    int top = 100000;
                    int left = 100000;
                    if (i > 0) {
                        top = result[i - 1][j];
                    }
                    if (j > 0) {
                        left = result[i][j - 1];
                    }
                    result[i][j] = Math.min(top, left) + 1;
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    int bottom = 100000;
                    int right = 100000;
                    if (i < matrix.length - 1) {
                        bottom = result[i + 1][j];
                    }
                    if (j < matrix[i].length - 1) {
                        right = result[i][j + 1];
                    }
                    result[i][j] = Math.min(result[i][j], Math.min(bottom, right) + 1);
                }
            }
        }
        return result;
    }
}