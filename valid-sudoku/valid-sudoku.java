/*

[[".",".",".",".","5",".",".","1","."]
 [".","4",".","3",".",".",".",".","."]
 [".",".",".",".",".","3",".",".","1"]
 ["8",".",".",".",".",".",".","2","."]
 [".",".","2",".","7",".",".",".","."]
 [".","1","5",".",".",".",".",".","."]
 [".",".",".",".",".","2",".",".","."]
 [".","2",".","9",".",".",".",".","."]
 [".",".","4",".",".",".",".",".","."]]
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check row
        //check column
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char rowVal = board[i][j];
                char colVal = board[j][i];
                if (rowSet.contains(rowVal) || colSet.contains(colVal)) {
                    return false;
                }
                if (rowVal != '.') {
                    rowSet.add(rowVal);
                }
                if (colVal != '.') {
                    colSet.add(colVal);
                }
            }
        }
        HashSet<Character> firstBox = new HashSet<>();
        HashSet<Character> secondBox = new HashSet<>();
        HashSet<Character> thirdBox = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j / 3 < 1) {
                    if (firstBox.contains(board[i][j])) {
                        return false;
                    }
                    if (board[i][j] != '.') {
                        firstBox.add(board[i][j]);
                    }
                }
                else if (j / 6 < 1) {
                    if (secondBox.contains(board[i][j])) {
                        return false;
                    }
                    if (board[i][j] != '.') { 
                        secondBox.add(board[i][j]);
                    }
                }
                else {
                    if (thirdBox.contains(board[i][j])) {
                        return false;
                    }
                    if (board[i][j] != '.') {
                        thirdBox.add(board[i][j]);
                    }
                }
            }
            if ((i + 1) % 3 == 0) {
                firstBox.clear();
                secondBox.clear();
                thirdBox.clear();
            }
        }
        return true;
    }
}