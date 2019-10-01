import java.util.Arrays;
import java.util.HashMap;

public class outofboundarypaths {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int mod = 1000000000 + 7;

    public int findPaths(int m, int n, int N, int i, int j) {
        // m * n grid
        long[][][] memo = new long[m][n][N+1];
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                for (int kk = 0; kk < N+1; kk++) {
                    memo[ii][jj][kk] = -1;
                }
            }
        }

        int res = 0;
        for (int i1=1;i1<=N;i1++){
            res += dfs(m, n, i1, i, j, memo) % mod;
        }
        return res;
    }

    public long dfs(int m, int n, int N, int i, int j, long[][][] memo) {
        // System.out.println(i + " "+j+" "+ N);
        //check if out of boundary, if out could not move back
        if (N==0) {
            if (i < 0 || i >= m || j < 0 || j >= n && N >= 0) {
                return 1;
            }
        }
        else if (N>0){
            if (i < 0 || i >= m || j < 0 || j >= n && N >= 0) {
                return 0;
            }
        }
        if (N == 0) return 0;
        if (memo[i][j][N] != -1) return memo[i][j][N];
        memo[i][j][N] = 0;
        for (int dir[] : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            memo[i][j][N] = (memo[i][j][N] + dfs(m, n, N - 1, x, y, memo) % mod) % mod;
        }
        return memo[i][j][N];

    }

}
