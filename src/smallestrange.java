import java.util.Arrays;

public class smallestrange {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int max = A[A.length-1];
        int min = A[0];
        int res = A[A.length-1] - A[0];

        for (int i=0;i<A.length-1;i++){
            max = Math.max(A[i]+K,A[A.length-1]-K);
            min = Math.min(A[i+1]-K,A[0]+K);
            res = Math.min(res,max-min);
        }
        return res;

    }
}
