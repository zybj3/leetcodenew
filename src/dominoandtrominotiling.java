public class dominoandtrominotiling {
    public int numTilings(int N) {
        long mod = 1000000007;
        long[] domino = new long[1001];
        long[] tromino = new long[1001];

        domino[0] = 0;
        domino[1] = 1;
        domino[2] = 2;
        tromino[0] = 0;
        tromino[1] = 1;
        tromino[2] = 2;

        for(int i=3;i<N+1;i++){
            domino[i] = (domino[i-1] + domino[i-2] + 2*tromino[i-2]) %mod;
            tromino[i] = (tromino[i-1] + domino[i-1]) %mod;
        }

        return (int)(domino[N]%mod);

    }
}
