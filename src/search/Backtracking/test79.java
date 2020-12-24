package search.Backtracking;

public class test79 {
    public static void main(String[] args) {
        char[][] board = {
                {'F','Y','C','E','N','R','D'},
                {'K','L','N','F','I','N','U'},
                {'A','A','A','R','A','H','R'},
                {'N','D','K','L','P','N','E'},
                {'A','L','A','N','S','A','P'},
                {'O','O','G','O','T','P','N'},
                {'H','P','O','L','A','N','O'}

        };
        Solution79 s = new Solution79();
        System.out.println(s.exist(board, "USA"));
    }
}

// class Solution {
//     int m,n;
//     boolean flg ;
//     int[][] dirtion = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//     public  boolean exist(char[][] board, String word) {
//         m = board.length;
//         n = board[0].length;
//         boolean[][] mark = new boolean[m][n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {

//                 flg = false;
//                 dfs(i, j, 0, word, board, mark);
//                 if (flg) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

//     private  void dfs(int i, int j, int index, String word, char[][] board, boolean[][] mark) {
//         if (board[i][j] != word.charAt(index)) {
//             return;
//         }
//         if (index == word.length() - 1 ) {
//             flg = true;
//             return;
//         }

//         mark[i][j] = true;
//         for (int k = 0; k < 4; k++) {
//             int newi = i + dirtion[k][0];
//             int newj = j + dirtion[k][1];
//             if (newi < 0 || newi >= m || newj < 0 || newj >= n) {
//                 continue;
//             }
//             if (mark[newi][newj]) {
//                 continue;
//             }
//             if (index + 1 >= word.length()) {
//                 continue;
//             }
//             if (board[newi][newj] != word.charAt(index + 1)) {
//                 continue;
//             }
//             dfs(newi,newj,index+1,word,board,mark);
//             if (flg) {
//                 break;
//             }
//         }
//         mark[i][j] = false;
//     }
// }


class Solution79 {
    int m,n;
    boolean flg ;
    int[][] dirtion = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public  boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ( dfs(i, j, 0, word, board, mark)) {
                    return true;
                }
            }
        }
        return false;
    }

    private  boolean dfs(int i, int j, int index, String word, char[][] board, boolean[][] mark) {
        if (i >= m || i < 0 || j >= n || j < 0||mark[i][j]||board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1 ) {
            return true;
        }

        mark[i][j] = true;
        boolean res = dfs(i+1,j,index+1,word,board,mark)||dfs(i-1,j,index+1,word,board,mark)
                ||dfs(i,j+1,index+1,word,board,mark)||dfs(i,j-1,index+1,word,board,mark);

        mark[i][j] = false;
        return res;
    }
}