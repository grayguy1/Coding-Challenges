class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int matr = mat.length;
        int matc = mat[0].length;
        if (matr * matc != r * c) {
            return mat;
        }
        int k = 0;
        int l = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < matr; i++) {
            for (int j = 0; j < matc; j++) {
                if (l >= c) {
                    k++;
                    l = 0;
                }
                result[k][l] = mat[i][j];
                l++;
            }
        }
        return result;
    }
}