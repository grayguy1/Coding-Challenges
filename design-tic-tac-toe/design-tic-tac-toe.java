class TicTacToe {
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    int n;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int p = 1;
        if (player == 2) {
            p = -1;
        }
        rows[row] += p;
        cols[col] += p;
        if (row == col) {
            diag += p;
        }
        if (col == cols.length - row - 1) {
            antiDiag += p;
        }
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */