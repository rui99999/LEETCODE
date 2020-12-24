package search.DFS;

public class test200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'0', '1', '0', '0'},
                {'1', '1', '1', '1'},
        };
        char[][] grid2 = {
                {'0'}

        };
        System.out.println(Solution200.numIslands(grid2));
    }
}
class Solution200 {
    public static int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ++ans;
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }

    static void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length||grid[i][j]=='0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}