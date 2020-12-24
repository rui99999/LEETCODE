package search.DFS;

public class test547 {
    public static void main(String[] args) {
        int[][] m ={
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };
        System.out.println(Solution547.findCircleNum(m));
    }
}
class Solution547 {
    public static int findCircleNum(int[][] M) {
        boolean[] mark = new boolean[M.length];
        int ans = 0;
        for (int i = 0; i < M.length; i++) {
            if (!mark[i]) {
                ++ans;
                dfs(i,M,mark);
            }
        }
        return ans;
    }

    static void dfs(int i,int[][] M,boolean[] mark ) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !mark[j]) {
                mark[j] = true;
                dfs(j,M,mark);
            }
        }
    }
}