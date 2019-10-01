import java.util.PriorityQueue;

public class shortestsubarraywithsumatleastK {
    public int shortestSubarray(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if (a[1]==b[1]){
                return b[0] - a[0];
            }else {
                return a[1] - b[1];
            }
        });

        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i=0;i<A.length;i++){
            sum += A[i];
            if (sum>=K){
                res = Math.min(res, i+1);
            }
            while (!pq.isEmpty() && sum-pq.peek()[1]>=K){
                res = Math.min(res, i - pq.poll()[0]);
            }
            pq.add(new int[]{sum, i});
        }

        return res==Integer.MAX_VALUE?-1:0;
    }
}
