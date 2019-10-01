public class cherrypickup {
    private int[][][] dp;
    private int[][] grid;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.dp = new int[grid.length][grid.length][grid.length];
        for (int i=0;i<dp.length;i++){
            for (int j=0; j<dp.length;j++){
                for (int k=0; k<dp.length; k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return Math.max(0, dp(grid.length-1,grid.length-1, grid.length-1));
    }


    public int dp(int x1, int y1, int x2){

        int y2 = x1 + y1 - x2;
        if (x1==0 && y1==0){
            return grid[0][0];
        }

        if (x1<0 || y1<0 || x2<0 || y2<0){
            return -1;
        }

        if (grid[x1][y1]<0 || grid[x2][y2]<0){
            return -1;
        }

        if (dp[x1][y1][x2]!=Integer.MIN_VALUE){
            return dp[x1][y1][x2];
        }
        dp[x1][y1][x2] = Max(dp(x1-1,y1,x2),dp(x1,y1-1,x2),dp(x1-1,y1,x2-1),dp(x1,y1-1,x2-1));

        if (dp[x1][y1][x2]>=0){
            dp[x1][y1][x2] += grid[x1][y1];
            if (x1!=x2) dp[x1][y1][x2] += grid[x2][y2];
        }

        return dp[x1][y1][x2];

    }

    private int Max(int a, int b, int c, int d){
        return Math.max(Math.max(a,b),Math.max(c,d));
    }
}
