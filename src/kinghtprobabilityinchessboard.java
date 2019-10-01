public class kinghtprobabilityinchessboard {
    double[][][] count;
    public double knightProbability(int N, int K, int r, int c) {
        count = new double[N][N][K+1];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                for (int k=0;k<K+1;k++){
                    count[i][j][k] = -1;
                }
            }
        }

        return dfs(N,K,r,c);
    }

    public double dfs(int N,int K,int r, int c){

        if (r<0 || r>=N || c<0 || c>=N && K>=0){
            return 0;
        }

        if (K==0){
            return 1;
        }

        if (count[r][c][K]!=-1){
            return count[r][c][K];
        }
        count[r][c][K] = 0;

        count[r][c][K] =0.125*(
                dfs(N,K-1,r-1,c-2)+
                        dfs(N,K-1,r-2,c-1)+
                        dfs(N,K-1,r-2,c+1)+
                        dfs(N,K-1,r-1,c+2)+
                        dfs(N,K-1,r+1,c+2)+
                        dfs(N,K-1,r+2,c+1)+
                        dfs(N,K-1,r+2,c-1)+
                        dfs(N,K-1,r+1,c-2));

        return count[r][c][K];


    }
}
