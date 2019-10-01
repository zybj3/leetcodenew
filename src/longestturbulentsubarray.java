import java.util.Arrays;

public class longestturbulentsubarray {
    public int maxTurbulenceSize(int[] A) {
        int[] top = new int[A.length];
        int[] down = new int[A.length];
        Arrays.fill(top,1);
        Arrays.fill(down,1);
        int len = 1;
        for (int i=1;i<A.length;i++){
            if (A[i]<A[i-1]){
                down[i] = top[i-1] + 1;
            }
            else if (A[i]>A[i-1]){
                top[i] = down[i-1] + 1;
            }
            int max = Math.max(top[i],down[i]);
            len = Math.max(max, len);
        }

        return len;
    }
}
