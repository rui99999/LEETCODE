package search.BFS;

import java.util.*;

public class test1091 {
    public static void main(String[] args) {
//new int[][]{{0,0,0},{1,1,0},{1,1,0}}
        System.out.println(Solution1091.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
    }
}
class Solution1091 {
    private static int row, col;
    public static int shortestPathBinaryMatrix(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        if (grid[row - 1][col - 1] == 1 || grid[0][0] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[row][col];
        //八个方向
        int[][] directions = {{0,1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        //记录已访问的节点
        visited[0][0] = 1;
        queue.add(new int[]{0, 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            //进一次循环走一步
            ++ans;
            int quesize = queue.size();
            //队列里所有元素都
            for (int i = 0; i < quesize; i++) {
                int[] temp = queue.poll();
                if (temp[0] == row - 1 && temp[1] == col - 1) {
                    return ans;
                }
                for (int j = 0; j < 8; j++) {
                    int newx = temp[0] + directions[j][0];
                    int newy = temp[1] + directions[j][1];
                    if (inGrid(newx, newy) && grid[newx][newy] == 0 && visited[newx][newy]==0) {
                        queue.add(new int[]{newx, newy});
                        visited[newx][newy] = 1;
                    }
                }
            }

        }
        return -1;
    }

    private static boolean inGrid(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }

}