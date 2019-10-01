public class longestIncreasingPathinaMatrix {
    private int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null || matrix.length==0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];

        int max = 1;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                max = Math.max(dfs(matrix, i, j, cache), max);
            }
        }

        return max;
    }

    public int dfs(int[][] matrix, int row, int col, int[][] cache){

        if (cache[row][col]!=0){
            return cache[row][col];
        }
        int max = 1;
        for (int i=0; i<dir.length; i++){
            int newrow = row + dir[i][0];
            int newcol = col + dir[i][1];

            if (newrow<0 || newrow>=matrix.length || newcol<0 || newcol>=matrix[0].length){
                continue;
            }

            int cur_val = matrix[row][col];
            int next_val = matrix[newrow][newcol];
            if (next_val<cur_val){
                max = Math.max(max, 1+ dfs(matrix, newrow, newcol, cache));
            }
        }

        cache[row][col] = max;

        return max;

    }
}
