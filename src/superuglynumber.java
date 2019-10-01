public class superuglynumber {
    public int nthUglyNumber(int n) {
        int[] primes = new int[]{2,3,5};
        int[] index = new int[3];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i=1;i<ugly.length;i++){
            ugly[i] = Integer.MAX_VALUE;
            for (int j=0;j<3;j++) {
                ugly[i] = Math.min(ugly[i], primes[j]*ugly[index[j]]);
            }

            for (int j=0;j<3;j++){
                while (primes[j]*ugly[index[j]]<=ugly[i]){
                    index[j]++;
                }
            }
        }

        return ugly[n-1];
    }
}
