package search.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test417 {
    public static void main(String[] args) {
        int[][] grid= {
                {1,1}, {1,1}, {1,1}

        };
        Solution417 s = new Solution417();
        System.out.println(s.pacificAtlantic(grid));
    }
}
class Solution417 {
    private int m,n;
    private  int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        m = matrix.length;
        n = matrix[0].length;
        boolean[][] canGoPo = new boolean[m][n];
        boolean[][] canGoAo = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            //边缘都可达
            canGoPo[i][0] = true;
            canGoAo[i][n - 1] = true;
            dfs(i, 0, canGoPo, matrix);
            dfs(i, n-1, canGoAo, matrix);
        }
        for (int i = 0; i < n; i++) {
            canGoPo[0][i] = true;
            canGoAo[m - 1][i] = true;
            dfs(0, i, canGoPo, matrix);
            dfs(m - 1, i, canGoAo, matrix);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canGoAo[i][j] && canGoPo[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, boolean[][] canGo, int[][] matrix) {
        for (int k = 0; k < direction.length; k++) {
            int newi = i + direction[k][0];
            int newj = j + direction[k][1];
            if (!(newi < 0 || newi >= m || newj < 0 || newj >= n
                    || matrix[i][j] > matrix[newi][newj]
                    || canGo[newi][newj])) {
                canGo[newi][newj] = true;
                dfs(newi, newj, canGo, matrix);
            }


//            if (newi >= 0 && newi < m  && newj >= 0 && newj < n
//                    && matrix[newi][newi] >= matrix[i][j]
//                    && !canGo[newi][newj]) {
//                canGo[newi][newj] = true;
//                dfs(newi, newj, canGo, matrix);
//            }
        }
    }
}