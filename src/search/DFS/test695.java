package search.DFS;

public class test695 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid2 = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}
                };
        System.out.println(Solution695.maxAreaOfIsland(grid2));

    }
}
class Solution695 {
    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max,dfs(i, j, grid));
            }
        }

        return max;
    }

    static int dfs(int x,int y,int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length||grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return 1 + dfs(x, y - 1, grid) + dfs(x + 1, y, grid) + dfs(x, y + 1, grid) + dfs(x - 1, y, grid);

    }
}
class Solution {
    int now;
    int max;
    public  int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                now = 0;
                dfs(i, j, grid);

            }
        }

        return max;
    }

    void dfs(int x,int y,int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||grid[x][y] == 0) {
            return;
        }

        now++;
        max = now > max ? now : max;
        grid[x][y] = 0;

        dfs(x, y - 1, grid);
        dfs(x + 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x - 1, y, grid);
    }
}