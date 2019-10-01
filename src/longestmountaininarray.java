import java.util.Arrays;

public class longestmountaininarray {
    public int longestMountain(int[] A) {
        int[] right = new int[A.length];
        int[] left = new int[A.length];

        Arrays.fill(right,1);
        Arrays.fill(left,1);
        for (int i=1;i<A.length;i++){
            if (A[i]>A[i-1]){
                left[i] = left[i-1] + 1;
            }
        }

        for (int i=A.length-2;i>=0;i--){
            if (A[i]>A[i+1]){
                right[i] = right[i+1] + 1;
            }
        }

        int res = 0;
        for (int i=0;i<A.length;i++){
            if (right[i]>1 && left[i]>1){
                res = Math.max(res,right[i]+left[i]-1);
            }
        }

        return res;
    }
}
