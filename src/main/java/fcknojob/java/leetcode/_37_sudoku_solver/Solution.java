package fcknojob.java.leetcode._37_sudoku_solver;

import java.util.HashSet;
import java.util.Set;

/*
 * backtracking
 * try Set<>[], tray array of Set
 * Set<Character>[] columnValids = new HashSet<Character>[9]; // generic array creation illegal
 */
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rowUsages = new boolean[9][9];
        boolean[][] columnUsages = new boolean[9][9];
        boolean[][][] squareUsages = new boolean[3][3][9];

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') updateUsages(c, i, j, rowUsages, columnUsages, squareUsages, true);
            }
        }

        tryFill(board, 81, rowUsages, columnUsages, squareUsages);

    }

    // suppose every board has one and only one solution
    private boolean tryFill(char[][] board, int N, boolean[][] rowUsages, boolean[][] columnUsages, boolean[][][] squareUsages) {
        if (N % 1 == 0) {System.out.println(N); printBoard(board, rowUsages, columnUsages, squareUsages);}
        if (N == 0) return true;
        int x = (N-1) / 9, y = (N-1) % 9;
        if (board[x][y] != '.') return tryFill(board, N-1, rowUsages, columnUsages, squareUsages);
        for (char c = '1'; c <= '9'; c++) {
            int d = c - '1';
            if (rowUsages[x][d] || columnUsages[y][d] || squareUsages[x/3][y/3][d]) continue;

            board[x][y] = c;
            updateUsages(c, x, y, rowUsages, columnUsages, squareUsages, true);
            if (tryFill(board, N-1, rowUsages, columnUsages, squareUsages)) return true;
            updateUsages(c, x, y, rowUsages, columnUsages, squareUsages, false);
            board[x][y] = '.';
        }
        return false;
    }


    private void updateUsages(char c, int x, int y, boolean[][] rowUsages, boolean[][] columnUsages, boolean[][][] squareUsages, boolean isAdd) {
        int d = c - '1';
        rowUsages[x][d] = isAdd;
        columnUsages[y][d] = isAdd;
        squareUsages[x/3][y/3][d] = isAdd;
    }

    private void printBoard(char[][] board, boolean[][] r, boolean[][] c, boolean[][][] s) {
        for (int i=0; i<9; i++) {
            System.out.println(board[i]);
        }
        System.out.println();
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                System.out.print(r[i][j] ? 1:0);
            }
            System.out.println();
        }
        System.out.println();
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                System.out.print(c[i][j] ? 1:0);
            }
            System.out.println();
        }
        System.out.println();
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                for (int k=0; k<9; k++) {
                    System.out.print(s[i][j][k] ? 1 : 0);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new Solution().solveSudoku(board);
    }

}

