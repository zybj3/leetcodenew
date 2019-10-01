import java.util.PriorityQueue;
import java.util.Stack;

public class partitionarrayintodisjointintervals {
    public int partitionDisjoint(int[] A) {
        if (A.length==2){
            return 1;
        }
        int[] leftmax = new int[A.length];
        int[] rightmin = new int[A.length];

        int max = A[0];
        leftmax[0] = A[0];
        for (int i=1;i<A.length;i++){
            if (A[i]>=max){
                leftmax[i] = A[i];
                max = A[i];
            }else {
                leftmax[i] = max;
            }
        }

        int min = A[A.length-1];
        rightmin[A.length-1] = A[A.length-1];
        for (int i=A.length-2;i>=0;i--){
            if (A[i]<=min){
                rightmin[i] = A[i];
                min = rightmin[i];
            }else {
                rightmin[i] = min;
            }
        }

        int index = 0;
        while (index<A.length-1){
            if (leftmax[index]<=rightmin[index+1]){
                return index+1;
            }
            index++;
        }

        return 0;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = a;
        a = 4;
        System.out.println(b);
    }
}
