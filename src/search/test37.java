package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test37 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution37 s = new Solution37();
        s.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
class Solution37 {
    boolean[][] row =new boolean[9][10];
    boolean[] [] col=new boolean[9][10];
    boolean[][][] block=new boolean[3][3][10];
    List<int[]> space = new ArrayList<>();
    boolean valid = false;
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    space.add(new int[]{i, j});
                }else {
                    int diag = board[i][j] - '0';
                    row[i][diag] = col[j][diag] = block[i / 3][j / 3][diag] = true;
                }
            }
        }
        dfs(board,0);
    }

    private void dfs(char[][] board, int index) {
        if (index == space.size()) {
            valid = true;
            return;
        }
        int x = space.get(index)[0];
        int y = space.get(index)[1];
        for (int i = 1; i < 10&&!valid; i++) {
            if (row[x][i] || col[y][i] || block[x / 3][y / 3][i]) {
                continue;
            }
            row[x][i] = col[y][i] = block[x / 3][y / 3][i] = true;
            board[x][y] = Character.forDigit(i,10);
            dfs(board, index + 1);
            row[x][i] = col[y][i] = block[x / 3][y / 3][i] = false;
        }
    }
}