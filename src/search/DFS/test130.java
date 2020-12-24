package search.DFS;

import java.util.Arrays;

public class test130 {
    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        char[][] grid2 = {
                {'O', 'O', 'X'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
        };
        char[][] grid3 = {

        };
        Solution130 s = new Solution130();
        s.solve(grid);
        System.out.println(Arrays.deepToString(grid));
    }


}
class Solution130{
    void solve(char[][] board){
        if (board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i,0);
            }
            if (board[i][board[0].length-1] == 'O') {
                dfs(board, i,board[0].length-1);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0,i);
            }
            if (board[board.length-1][i] == 'O') {
                dfs(board, board.length-1,i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i,int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i , j+1);
        dfs(board, i , j-1);

    }

}



//class Solution130 {
//    List<int[]> rote ;
//    public void solve(char[][] board) {
//        if (board.length == 0) {
//            return;
//        }
//        boolean[][] mark = new boolean[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == 'O' && !mark[i][j]) {
//                    rote = new ArrayList<>();
//                    boolean flag = true;
//                    dfs(i,j,mark,board);
//                    for (int[] item : rote) {
//                        if (item[0] >= board.length - 1 || item[1] >= board[0].length - 1
//                        ||item[0]<=0||item[1]<=0) {
//                            flag = false;
//                        }
//                    }
//                    if (flag) {
//                        for (int[] item : rote) {
//                            int x = item[0];
//                            int y = item[1];
//                            board[x][y] = 'X';
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public void dfs(int i, int j, boolean[][] mark,char[][] board) {
//        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||board[i][j] == 'X'||mark[i][j]) {
//            return;
//        }
//        rote.add(new int[]{i, j});
//        mark[i][j] = true;
//        dfs(i + 1, j, mark, board);
//        dfs(i - 1, j, mark, board);
//        dfs(i , j+1, mark, board);
//        dfs(i , j-1, mark, board);
//
//    }
//}