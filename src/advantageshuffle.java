import java.util.*;

public class advantageshuffle {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] res = new int[A.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>();
        for (int i=0;i<B.length;i++){
            pq.offer(new int[]{B[i],i});
        }

        int low = 0, high = A.length-1;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int index = cur[1];
            int num = cur[0];

            if (A[high]>num){
                res[index] = A[high--];
            }else res[index] = A[low++];
        }
        return res;
    }
}
