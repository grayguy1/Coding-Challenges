class TicTacToe {

    int[] rows;
    int[] columns;
    int diag = 0;
    int opDiag = 0;
    int n;
    public TicTacToe(int n) {
        rows = new int[n];
        columns = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        if (player == 1) {
            rows[row]++;
            columns[col]++;
            if (row == col) {
                diag++;
            }
            if (col == n - row - 1) {
                opDiag++;
            }
        }
        else {
            rows[row]--;
            columns[col]--;
            if (row == col) {
                diag--;
            }
            if (col == n - row - 1) {
                opDiag--;
            }
        }
        if (Math.abs(rows[row]) == n || Math.abs(columns[col]) == n || Math.abs(diag) == n || Math.abs(opDiag) == n) {
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