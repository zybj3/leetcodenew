public class numberofislands {
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,visited,i,j);
                    res += 1;
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int col){
        if (row<0 || row>=grid.length){
            return;
        }

        if (col<0 || col>=grid[0].length){
            return;
        }

        if (visited[row][col]){
            return;
        }

        if (grid[row][col]=='1') {
            visited[row][col] = true;
            dfs(grid, visited, row + 1, col);
            dfs(grid, visited, row - 1, col);
            dfs(grid, visited, row, col + 1);
            dfs(grid, visited, row, col - 1);
        }
    }
}
