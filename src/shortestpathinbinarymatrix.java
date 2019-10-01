import java.util.LinkedList;
import java.util.Queue;

public class shortestpathinbinarymatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0]==1){
            return -1;
        }
        int[][] dir = new int[][]{{1,1},{-1,1},{1,-1},{-1,-1},{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        boolean[][] visited = new boolean[grid.length][grid.length];
        visited[0][0] = true;
        int len = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                int[] cur = queue.poll();
                for (int i=0;i<dir.length;i++){
                    int row = cur[0] + dir[i][0];
                    int col = cur[1] + dir[i][1];
                    if (row==grid.length-1 && col==grid.length-1){
                        return len+1;
                    }
                    if (row>=0 && row<=grid.length-1 && col>=0 && col<=grid.length-1){
                        if (!visited[row][col] && grid[row][col]==0){
                            queue.add(new int[]{row,col});
                            visited[row][col] = true;
                        }
                    }
                }

                size--;
            }

            len++;
        }

        return -1;
    }
}
