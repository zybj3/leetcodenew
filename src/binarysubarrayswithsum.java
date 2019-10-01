import java.util.HashMap;

public class binarysubarrayswithsum {
    public int numSubarraysWithSum(int[] A, int S) {
        int count = 0,sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0;i<A.length;i++){
            sum += A[i];
            count += map.getOrDefault(sum-S,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
