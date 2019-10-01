public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i=0; i<n; i++){
            if (!visited[i])
            {
                visited[i] = true;
                dfs(i, visited, M);
                res++;
            }
        }

        return res;
    }


    private void dfs(int personId, boolean[] visited, int[][] M){
        for (int i=0; i<M.length; i++){
            if (i==personId){
                continue;
            }
            if(M[personId][i]==1 && !visited[i]){
                visited[i] = true;
                dfs(i, visited, M);
            }
        }

        return;
    }



}
