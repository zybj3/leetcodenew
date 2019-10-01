import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class twosumlessthanK {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int left = 0, right = A.length - 1;
        int s = 0;
        while (left<right){
            if (A[left] + A[right] >= K){
                right--;
            }else {
                s = Math.max(A[left]+A[right], s);
                left++;
            }
        }

        return s==0 ? -1:s;
    }
}
