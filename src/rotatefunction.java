public class rotatefunction {
    public int maxRotateFunction(int[] A) {
        int allsum = 0;
        int F = 0;
        for (int i=0;i<A.length;i++){
            F += A[i] * i;
            allsum += A[i];
        }

        int max = F;
        for (int i=A.length-1;i>=1;i--){
            F = F + allsum - A.length * A[i];
            max = Math.max(F,max);
        }

        return max;


    }
}
